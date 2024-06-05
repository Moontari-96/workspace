package controll;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dao.ReplyDAO;
import dto.ReplyDTO;

@WebServlet("*.reply")
public class ReplyController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); 
		// 클라이언트로부터 전송되는 문자열에 대한 인코딩을 utf8로 처리
		//request에서 값을 꺼내기 전에 처리해야만 함!
		response.setContentType("text/html; charset=UTF-8");
		String cmd = request.getRequestURI();
		System.out.println(cmd);
		ReplyDAO dao = ReplyDAO.getInstance();
		try { 
			if(cmd.equals("/write.reply")) {
				String writer = (String)request.getSession().getAttribute("loginID");
				String replyCon = request.getParameter("replyCon");
				int seq = Integer.parseInt(request.getParameter("replyPseq"));
				System.out.println(replyCon);
				System.out.println(seq);
				dao.insertReply(new ReplyDTO(0, writer, replyCon, null, seq));
				response.sendRedirect("/detail.board?seq=" + seq);
				// response.sendRedirect("/list.reply?replyPseq=" + replyPseq);
				//request.getRequestDispatcher("/detail.board?seq="+seq).forward(request, response);
			} else if(cmd.equals("/delete.reply")) {
				int replyseq = Integer.parseInt(request.getParameter("replyseq"));
				System.out.println(replyseq);
				int seq = Integer.parseInt(request.getParameter("seq"));
				System.out.println(seq);
				dao.deleteReply(replyseq);
				response.sendRedirect("/detail.board?seq=" + seq);
			} else if(cmd.equals("/update.reply")) {
				String replyContents = request.getParameter("replyContents");
				System.out.println(request.getParameter("replyseq"));
				System.out.println(request.getParameter("seq"));
				int replyseq = Integer.parseInt(request.getParameter("replyseq"));
				int seq = Integer.parseInt(request.getParameter("seq"));
				dao.updateReply(new ReplyDTO(replyseq,"",replyContents,null,0));
				response.sendRedirect("/detail.board?seq=" + seq);
			} else if(cmd.equals("/list.reply")) {
				String loginID = (String)request.getSession().getAttribute("loginID");
				int seq = Integer.parseInt(request.getParameter("parent_seq"));
				Gson g = new Gson();
				String result = g.toJson(dao.selectAll(seq));
				PrintWriter pw = response.getWriter();
				//pw.append(result);
				pw.append(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/error.jsp");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
