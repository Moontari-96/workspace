package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exam01")
// 클라이언트가 요청한 값을 불러오기 위한 서블릿 이름 form 액션 안에 사용 
public class Exam01 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 처리
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		System.out.println("writer : " + writer);
		System.out.println("content : " + content);
		// 2. 응답
		PrintWriter  pw =  response.getWriter();
		pw.append("<html>");
		pw.append("<body>");
		pw.append("Process Complete");
		pw.append("<button id = 'ok'>Ok</button>");
		pw.append("<script>");
		pw.append("document.getElementById('ok').onclick=function(){location.href='/index.html';}");
		pw.append("</script>");
		pw.append("</body>");
		pw.append("</html>");
	}

	// protected는 자바에서 오버라이딩해서 사용하는것을 추천한다는 관습적 표현도 있음
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		System.out.println("Post방식 요청 확인");
	}

}
