package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDAO;
import dto.MovieDTO;

// MVC1 디자인 패턴 : Model에 해당하는 데이터 처리 클래스만 분리되고, Controller와 View가 함께 처리되는 디자인 패턴
// 단점 1. 역할 분담이 어렵다. ( Servlet이 자바코드인 Controller와 HTML코드인 View를 함께 작성하므로 역할 분리가 안된다. )
// 단점 2. Servlet에서 프론트 코드 작성은 너무나도 불편하다.

// * 단점 2를 해결하기 위해 JSP가 등장.

// * 단점 1을 해결하기 위해 MVC2 등장.
// MVC2 디자인 패턴 : Model / View / Controller가 완벽하게 분리되는 구조의 디자인 패턴


@WebServlet("/InputServlet")
public class InputServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("movieName");
		String genre = request.getParameter("movieGenre");
		MovieDAO dao = MovieDAO.getInstance();
		try {
			int result = dao.insertMovie(new MovieDTO(0,title,genre,null));
			request.setAttribute("result", result);
			response.sendRedirect("inputview.jsp");
//			request.getRequestDispatcher("inputview.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Servlet & JSP ( Java Server Page )
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
