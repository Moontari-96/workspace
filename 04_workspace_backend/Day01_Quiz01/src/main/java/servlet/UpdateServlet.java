package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MovieDAO;
import dto.MovieDTO;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upID = request.getParameter("upID");
		String upTitle = request.getParameter("upTitle");
		String upGenre = request.getParameter("upGenre");
		MovieDAO dao = MovieDAO.getInstance();
		int numID = 0;
		if(upID != null && upID != "") {
			numID = Integer.parseInt(upID);
			try {
				int upResult = dao.updateMovie(new MovieDTO(numID, upTitle, upGenre, null));
				response.sendRedirect("OutputServlet");
				//	request.setAttribute("upResult", upResult);
				//	response.sendRedirect("OutputServlet"); 클라이언트의 브라우저 주소값이 변경된다.
				
				// request.getRequestDispatcher("OutputServlet").forward(request, response); // 클라이언트는 페이지가 전환되었음을 ( 서블릿 -> JSP ) 인지 할 수 없다.( 주소값 변경 無 )
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				response.sendRedirect("OutputServlet");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
