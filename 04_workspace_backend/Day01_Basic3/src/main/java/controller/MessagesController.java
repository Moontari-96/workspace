package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessagesDAO;
import dto.MessagesDTO;

@WebServlet("*.msg")
public class MessagesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		System.out.println(cmd);
		//
		MessagesDAO dao = MessagesDAO.getInstance();
				;
		try {
			if(cmd.equals("/input.msg")) {
				String writer = request.getParameter("writer");
				String content = request.getParameter("content");
				dao.insert(new MessagesDTO(0,writer, content, null));
				response.sendRedirect("/output.msg");
			} else if (cmd.equals("/output.msg")) {
				List<MessagesDTO> list = dao.selectAll();
				for (MessagesDTO dto : list) {
					System.out.println(dto.getId());
				}
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputview.jsp").forward(request,response);
			} 
			else if (cmd.equals("/delete.msg")) {
				String delInp = request.getParameter("delInp");
				int target = 0;
				System.out.println(target);
				if (delInp != null && delInp != "") {
					target = Integer.parseInt(delInp);
					dao.deleteMessage(target);
					System.out.println(target);
					response.sendRedirect("/output.msg");
				} else {
					response.sendRedirect("/output.msg");
				}
			} else if (cmd.equals("/update.msg")) {
				String upId =request.getParameter("upId"); 
				String upWriter =request.getParameter("upWriter"); 
				String upMessage =request.getParameter("upMessage"); 
				String upDate =request.getParameter("upDate"); 
				int idChk = 0;
				if (upId != null && upId != "") {
					idChk = Integer.parseInt(upId);
					dao.updateMessage(new MessagesDTO(idChk, upWriter, upMessage, null));
					response.sendRedirect("/output.msg");
				} else {
					response.sendRedirect("/output.msg");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
