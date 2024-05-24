package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessagesDAO;
import dto.MessagesDTO;

@WebServlet("/OutputServlet")
public class OutputServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DBCP 생성 과부화를 차단하기 위한 방법
		// 1. Singleton Instance
		MessagesDAO dao = MessagesDAO.getInstance();
		try {
			List<MessagesDTO> list = dao.selectAll();
			PrintWriter pw = response.getWriter();
			pw.append("<html>");
			pw.append("<head>");
			pw.append("</head>");
			pw.append("<body>");
			pw.append("<table border=1 align='center'>");
			pw.append("<tr>");
			pw.append("<th>ID");
			pw.append("<th>Writer");
			pw.append("<th>Message");
			pw.append("<th>Date");
			pw.append("</tr>");
			for(MessagesDTO dto : list) {
				pw.append("<tr>");
				pw.append("<td>" + dto.getId());
				pw.append("<td>" + dto.getWriter());
				pw.append("<td>" + dto.getMessage());
				pw.append("<td>" + dto.getWrite_date());
				pw.append("</tr>");
			}
			pw.append("</table>");
			pw.append("</body>");
			pw.append("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
