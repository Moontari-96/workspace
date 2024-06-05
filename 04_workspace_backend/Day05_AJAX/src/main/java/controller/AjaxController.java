package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import dto.MovieDTO;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String cmd = request.getRequestURI();
		Gson g = new Gson();
		PrintWriter pw = response.getWriter();
		if(cmd.equals("/exam01.ajax")) {
			System.out.println("단순 요청 확인");
		} else if (cmd.equals("/exam02.ajax")) {
			String param1 = request.getParameter("key1");
			String param2 = request.getParameter("key2");
			System.out.println(param1 + " : " + param2);
		} else if (cmd.equals("/exam03.ajax")) {
			pw.append("AJAX 응답 데이터 입니다.");
		} else if (cmd.equals("/exam04.ajax")) {
			String[] fruits = new String[] {"Orange","Mango","Apple"};
			
			String result = g.toJson(fruits);
			System.out.println(result);
			pw.append(result);
			// 수동 직렬화
			// pw.append("[\"" + fruits[0] + "\",\"" + fruits[1] + "\",\"" + fruits[2] + "\"]");
			// 클라이언트와 서버와 주고 받을 수 있는 데이터 타입은 String type만 허용
		} else if (cmd.equals("/exam05.ajax")) {
			MovieDTO dto = new MovieDTO(1001,"범죄도시4","액션");
			String result = g.toJson(dto);
			pw.append(result);
		} else if (cmd.equals("/exam06.ajax")) {
			List<MovieDTO> list = new ArrayList<>();
			list.add(new MovieDTO(1001,"범죄도시4","액션"));
			list.add(new MovieDTO(1002,"범죄도시5","코미디"));
			list.add(new MovieDTO(1003,"범죄도시6","로맨스"));
			String result = g.toJson(list);
			pw.append(result);
		} else if (cmd.equals("/exam07.ajax")) {
			JsonObject obj = new JsonObject(); // "{ }"
			obj.addProperty("fruits", "Apple");
			obj.addProperty("title", "범죄도시4");
			
			JsonArray arr = new JsonArray(); // "[ ]"
			
			pw.append(obj.toString());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
