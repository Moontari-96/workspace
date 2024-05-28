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
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO dao = MovieDAO.getInstance();
		if ((request.getParameter("delInp") != null) && (request.getParameter("delInp") != "")) {
			try {
				int target = Integer.parseInt(request.getParameter("delInp"));
				int delResult = dao.delMovie(target);
				response.sendRedirect("OutputServlet");
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
		} else {
			try {
				response.sendRedirect("OutputServlet");
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
