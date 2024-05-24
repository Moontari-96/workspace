package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessagesDAO;
import dto.MessagesDTO;

@WebServlet("/Inputservlet")
public class InputServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MessagesDAO dao = MessagesDAO.getInstance();
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		try {
			int result = dao.insert(new MessagesDTO(0,writer, content,null));
			if(result>0) {
				System.out.println("성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
