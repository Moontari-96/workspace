package controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import commons.BoardConfig;
import dao.BoardDAO;
import dto.BoardDTO;


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
				
				String pageNavi = dao.getPageNavi(cpage);
				
				request.setAttribute("list", list);
				request.setAttribute("navi", pageNavi);
				request.getRequestDispatcher("/board/list.jsp").forward(request, response);
			} else if (cmd.equals("/write.board")) {
				String writer = (String)request.getSession().getAttribute("loginID");
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				System.out.println(content);
				int result = dao.insert(new BoardDTO(0,writer,title,content,null,0));
				response.sendRedirect("/list.board");
			} else if (cmd.equals("/detail.board")) {
				String seq = request.getParameter("seq");
				String loginID = (String)request.getSession().getAttribute("loginID");
				int seqNum = Integer.parseInt(seq);
				BoardDTO dto = dao.detailBoard(seqNum);
				dao.updateViewCount(seqNum);
				request.setAttribute("dto", dto);
				request.setAttribute("loginID", loginID);
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
