package controll;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import commons.EncryptionUtils;
import dao.MembersDAO;
import dto.MembersDTO;

@WebServlet("*.mem")
public class MembersController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String cmd = request.getRequestURI();
		System.out.println(cmd);
		MembersDAO dao = MembersDAO.getInstance();
		try {
			if(cmd.equals("/idcheck.mem")) {
				String id = request.getParameter("id");
				System.out.println(id);
				boolean result = dao.checkID(id);
				System.out.println(result);
				request.setAttribute("result", result);
				request.getRequestDispatcher("/members/idcheck.jsp").forward(request, response);
			} else if (cmd.equals("/signup.mem")){
				System.out.println("우선진입");
				String id = request.getParameter("id");
				String pw = EncryptionUtils.getSHA512(request.getParameter("pw"));
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				String zipcode = request.getParameter("zipcode");
				String address1 = request.getParameter("address1");
				String address2 = request.getParameter("address2");
				System.out.println(phone);
				System.out.println(email);
				System.out.println(zipcode);
				System.out.println(address1);
				System.out.println(address2);
				int result = dao.joinMembers(new MembersDTO(id, pw, name, phone, email, zipcode, address1, address2, null));
				if(result>0) {
					System.out.println("저장");
				}
				response.sendRedirect("/index.jsp");
			} else if(cmd.equals("/login.mem")){
				String id = request.getParameter("id");
				String pw = EncryptionUtils.getSHA512(request.getParameter("pw"));
				boolean result = dao.checkLogin(id, pw);
				if(result) {
					// String loginID = id;		
					// request.setAttribute("loginID", id);
					// MembersController.id = id; <-- public static 으로도 보관도 불가 ( 다중 사용자 환경이기 때문 )	
					
					HttpSession session = request.getSession();
					// JSON (MAP) 내에 JSON (MAP) 을 저장하는 방식
					session.setAttribute("loginID", id);
					
					// session = {
					// 1000 : {loginID:id}
					// 1001 : {}
					// }
					
					// 1. cookie 파일
					// 로그인 성공 후, 인증되었다는 정보를 클라이언트에게 제공하여 파일로 보관하게 함.
					// 향후 클라이언트가 서버에 어떤 파일에 접근하던지 쿠키파일을 제시하면 인증 사용자임을 확인할 수 있음.
					// 예시> 집 키를 클라이언트가 가지고 있다가 필요할 때마다 들고 가서 마음대로 여는 방식
					
					// 2. session
					// 로그인 성공 후, 인증되었다는 정보에 접근할 수 있는 key를 클라이언트에게 제공하여 보관하게 함.
					// 향후 클라이언트가 서버에 어떤 파일에 접근하던지 key를 제시하여 인증된 사용자임을 확인할 수 있음.
					// 예시> 금고 은행에 키를 제시하여 인증여부를 확인하는 방식
					// 		서버측에서 사용자에 대한 추가적인 검증을 수행할 수 있음 ( IP, User-Agent )
					
					// 각각의 장단점
					// Cookie - 인증 정보를 클라이언트가 보관하므로 서버에 부하가 상대적으로 낮음.
					// 			반면 인증정보를 탈취 당할 시, 해킹으로 매우 취약함
					
					// session - 인증 정보를 탈취 당해도, 서버측 추가 검증을 통해 보안성을 확립할 수 있음.
					//			 인증 정보를 서버측에 보관하며, 추가 검증 로직이 들어가므로 서버 부하가 상대적으로 높음.
					System.out.println("로그인 성공");
				} else {
					System.out.println("로그인 실패");
				} 
				response.sendRedirect("index.jsp");
			} else if(cmd.equals("/logout.mem")) {
				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect("index.jsp");
			} else if (cmd.equals("/memberout.mem")) {
				HttpSession session = request.getSession();
				String deleteID = (String)session.getAttribute("loginID");
				System.out.println(deleteID);
				dao.cancleMember(deleteID);
				session.invalidate();
				response.sendRedirect("index.jsp");
			} else if (cmd.equals("/mypage.mem")) {
				System.out.println("진입");
				HttpSession session = request.getSession();
				String mypageID = (String)session.getAttribute("loginID");
				MembersDTO dto = dao.inMypage(mypageID);
				request.setAttribute("dto", dto);
				request.getRequestDispatcher("/members/mypage.jsp").forward(request, response);
			} else if (cmd.equals("/modifyUser.mem")) {
				String id = request.getParameter("id");
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				String zipcode = request.getParameter("zipcode");
				String address1 = request.getParameter("address1");
				String address2 = request.getParameter("address2");
				System.out.println(name);
				System.out.println(phone);
				System.out.println(email);
				System.out.println(zipcode);
				System.out.println(address1);
				System.out.println(address2);
				dao.modifyUser(new MembersDTO(id,null,name,phone,email,zipcode,address1,address2,null));
				response.sendRedirect("index.jsp");
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
