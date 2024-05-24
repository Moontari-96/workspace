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
				//	request.setAttribute("upResult", upResult);
				response.sendRedirect("OutputServlet");
				// request.getRequestDispatcher("OutputServlet").forward(request, response);
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
