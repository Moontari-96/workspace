package controll;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
				List<BoardDTO> list = dao.selectAll();
				request.setAttribute("list", list);
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
				String writer = (String)request.getSession().getAttribute("loginID");
				int seqNum = Integer.parseInt(seq);
				BoardDTO dto = dao.detailBoard(seqNum);
				request.setAttribute("dto", dto);
				request.setAttribute("writer", writer);
				request.getRequestDispatcher("/board/detail.jsp").forward(request, response);
			} else if (cmd.equals("/delete.board")) {
				String writer = (String)request.getSession().getAttribute("loginID");
				String seq = request.getParameter("seq");
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
