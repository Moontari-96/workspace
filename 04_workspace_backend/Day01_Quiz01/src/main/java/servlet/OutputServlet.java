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
@WebServlet("/OutputServlet")
public class OutputServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO dao = MovieDAO.getInstance();
		
		try {
			List<MovieDTO> list = dao.selectAll();
			// String[] arr = new String[] {
			// 	"Mango","Orange","Apple"
			// };
			// MovieDTO dto = new MovieDTO(9999,"Jack","EL 연습",null);
			// request.setAttribute("param1", 10);
			// request.setAttribute("param2", "Hello JSP");
			// request.setAttribute("fruits", arr);
			// request.setAttribute("movie", dto);
			request.setAttribute("list", list);
			request.getRequestDispatcher("outputview.jsp").forward(request,response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
