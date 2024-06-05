package controll;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import commons.BoardConfig;
import dao.BoardDAO;
import dao.FilesDAO;
import dao.ReplyDAO;
import dto.BoardDTO;
import dto.FilesDTO;


@WebServlet("*.board")
public class BoardController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		// 클라이언트로부터 전송되는 문자열에 대한 인코딩을 utf8로 처리
		//request에서 값을 꺼내기 전에 처리해야만 함!
		response.setContentType("text/html; charset=UTF-8");
		String cmd = request.getRequestURI();
		System.out.println(cmd);
		BoardDAO dao = BoardDAO.getInstance();
		ReplyDAO rDao = ReplyDAO.getInstance();
		FilesDAO fDao = FilesDAO.getInstance();
		
		try {
			if(cmd.equals("/list.board")) {
				String pcpage = request.getParameter("cpage");
				if( pcpage == null) {
					pcpage = "1";
				}
		
				int cpage = Integer.parseInt(pcpage);
				// List<BoardDTO> list = dao.selectAll();
				List<BoardDTO> list = dao.selectNtoM(cpage * BoardConfig.recordCountPerPage - (BoardConfig.recordCountPerPage -1),
						cpage * BoardConfig.recordCountPerPage);
				
				// String pageNavi = dao.getPageNavi(cpage);
				// request.setAttribute("navi", pageNavi);
				request.setAttribute("list", list);
				request.setAttribute("cpage", cpage);
				request.setAttribute("record_count_per_page", BoardConfig.recordCountPerPage);
				request.setAttribute("navi_count_per_page", BoardConfig.naviCountPerPage);
				request.setAttribute("record_total_count", dao.getRecordCount());
				
				request.getRequestDispatcher("/board/list.jsp").forward(request, response);
			} else if (cmd.equals("/write.board")) {
				int maxSize = 1024 * 1024 * 10; // 10 메가 사이즈 제한
				String realPath = request.getServletContext().getRealPath("files");// 파일이 저장될 위치
				
				File uploadPath = new File(realPath); // 저장 위치 폴더를 파일 인스턴스로 생성
				if(!uploadPath.exists()) {
					uploadPath.mkdir();
				} // 파일 업로드 폴더가 존재하지 않을 경우 직접 생성
				
				// 1번 인자 : multipart/form-data로 인코딩 된 request
				// 2번 인자 : 파일이 첨부되어 있다면 파일이 업로드 될 경로
				// 3번 인자 : 업로드 파일 사이즈 제한
				// 4번 인자 : 한글 데이터나 한문 데이터등에 대한 깨짐을 방지하기 위한 인코딩 처리 
				// 5번 인자 : 파일 이름이 겹치는 경우 이름을 자동으로 변경해주는 정책 ex) A.txt가 두개인 경우 A와 A1로 저장 후에 저장된 값이 이름 변경됌
				MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "UTF8", new DefaultFileRenamePolicy());
				
				
				
				String writer = (String)request.getSession().getAttribute("loginID");
				String title = multi.getParameter("title");
				String content = multi.getParameter("content");
				System.out.println(title);
				System.out.println(content);
				System.out.println(realPath);
				int result = dao.insert(new BoardDTO(0,writer,title,content,null,0));
				Enumeration<String> names = multi.getFileNames();
				while(names.hasMoreElements()) {
					String name = names.nextElement();
					String oriName = multi.getOriginalFileName(name); // 원본 이름
					String sysName = multi.getFilesystemName(name); // 서버에 저장 되었을 때 이름
					if(oriName != null) {
						fDao.insert(new FilesDTO(0,oriName,sysName,result));
					}
				}
				response.sendRedirect("/list.board");
			} else if (cmd.equals("/detail.board")) {
				String seq = request.getParameter("seq");
				// String seq = (String)request.getAttribute("seq");
				System.out.println(request);
				System.out.println(seq);
				String loginID = (String)request.getSession().getAttribute("loginID");
				int seqNum = Integer.parseInt(seq);
				BoardDTO dto = dao.detailBoard(seqNum);
				dao.updateViewCount(seqNum);
				request.setAttribute("dto", dto);
				request.setAttribute("loginID", loginID);
				request.setAttribute("replyList", rDao.selectAll(seqNum));
				System.out.println(rDao.selectAll(seqNum));
				List<FilesDTO>list = fDao.selectAll(seqNum);
				request.setAttribute("list", list);
				request.getRequestDispatcher("/board/detail.jsp").forward(request, response);
			} else if (cmd.equals("/delete.board")) {
				int seq = Integer.parseInt(request.getParameter("seq"));
				dao.deleteBoard(seq);
				response.sendRedirect("/list.board");
			} else if (cmd.equals("/update.board")) {
				int seq = Integer.parseInt(request.getParameter("seq"));
				String content = request.getParameter("content");
				String title = request.getParameter("title");
				System.out.println(seq);
				System.out.println(content);
				System.out.println(title);
				dao.updateBoard(new BoardDTO(seq,null,title,content,null,0));
				response.sendRedirect("/list.board");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
