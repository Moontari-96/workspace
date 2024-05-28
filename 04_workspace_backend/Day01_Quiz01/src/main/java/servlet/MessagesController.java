package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.MovieDAO;
import dto.MovieDTO;

@WebServlet("*.messages")
public class MessagesController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// .messages 주소값(이름)가져오기
		String cmd = request.getRequestURI();
		System.out.println(cmd);
		// new MovieDAO 대신 인스턴스화 
		// 메서드 사용을 위함
		MovieDAO dao = MovieDAO.getInstance();
		// 분기처리
		try {
			if(cmd.equals("/input.messages")) {
				// 입력 서블릿
				String title = request.getParameter("movieName");
				String genre = request.getParameter("movieGenre");
				int result = dao.insertMovie(new MovieDTO(0,title,genre,null));
				response.sendRedirect("/output.messages");
			}
			else if (cmd.equals("/output.messages")){
				// 출력 서블릿
				List<MovieDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputview.jsp").forward(request,response);
			} else if (cmd.equals("/delete.messages")) {
				// 삭제 서블릿
				if ((request.getParameter("delInp") != null) && (request.getParameter("delInp") != "")) {
					int target = Integer.parseInt(request.getParameter("delInp"));
					int delResult = dao.delMovie(target);
					response.sendRedirect("/output.messages");
				}
			} else if (cmd.equals("/update.messages")) {
				// 수정 서블릿
				String upID = request.getParameter("upID");
				String upTitle = request.getParameter("upTitle");
				String upGenre = request.getParameter("upGenre");
				int numID = 0;
				if(upID != null && upID != "") {
					numID = Integer.parseInt(upID);
					int upResult = dao.updateMovie(new MovieDTO(numID, upTitle, upGenre, null));
					response.sendRedirect("/output.messages");
				} else {
					response.sendRedirect("/output.messages");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
			// TODO: handle exception
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
