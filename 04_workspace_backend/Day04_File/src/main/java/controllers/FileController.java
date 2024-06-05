package controllers;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.FilesDAO;
import dto.FilesDTO;

@WebServlet("*.file")
public class FileController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String cmd = request.getRequestURI();
		System.out.println(cmd);
		FilesDAO dao = FilesDAO.getInstance();
		try {
			if(cmd.equals("/upload.file")) {
				int maxSize = 1024 * 1024 * 10; // 10 메가 사이즈 제한
				String realPath = request.getServletContext().getRealPath("files");// 파일이 저장될 위치
				
				File uploadPath = new File(realPath); // 저장 위치 폴더를 파일 인스턴스로 생성
				if(!uploadPath.exists()) {
					uploadPath.mkdir();
				} // 파일 업로드 폴더가 존재하지 않을 경우 직접 생성
				
				// 1번 인자 : multipart/form-data로 인코딩 된 request
				// 2번 인자 : 파일이 첨부되어 있다면 파일이 업로드 될 경로
				// 3번 인자 : 업로드 파일 사이즈 제한
				// 4번 인자 : 한글 데이터나 한문 데이터등에 대한 깨짐을 방지하기 위한 인코딩 처리 
				// 5번 인자 : 파일 이름이 겹치는 경우 이름을 자동으로 변경해주는 정책 ex) A.txt가 두개인 경우 A와 A1로 저장 후에 저장된 값이 이름 변경됌
				MultipartRequest multi = new MultipartRequest(request, realPath, maxSize, "UTF8", new DefaultFileRenamePolicy());
				System.out.println(realPath);
				String message = multi.getParameter("message");
				System.out.println("클라이언트 메시지 : " + message);
				
				
				
				System.out.println(realPath);
				Enumeration<String> names = multi.getFileNames();
				while(names.hasMoreElements()) {
					String name = names.nextElement();
					String oriName = multi.getOriginalFileName(name); // 원본 이름
					String sysName = multi.getFilesystemName(name); // 서버에 저장 되었을 때 이름
					if(oriName != null) {
						dao.insert(new FilesDTO(0,oriName,sysName,0));
					}
				}
				response.sendRedirect("/index.jsp");
			} else if (cmd.equals("/list.file")) {
				List<FilesDTO>list = dao.selectAll();
				request.setAttribute("list", list);
				Gson g = new Gson();
				String result = g.toJson(list);
				PrintWriter pw = response.getWriter();
				pw.append(result);
			} else if (cmd.equals("/download.file")) {
				
				
				// 다운 받을 파일의 위치 확보
				String filepath = request.getServletContext().getRealPath("files");
				// 다운 받을 파일 이름 확보
				String sysname = request.getParameter("sysname");
				String oriname = request.getParameter("oriname");
				
				oriname = new String(oriname.getBytes("UTF8"),"ISO-8859-1");
				
				response.reset();
				response.setHeader("Content-Disposition", "attachment;filename=\""+oriname+"\"");
				
				// 위치와 이름을 결합하여 타겟 파일 인스턴스 생성
				File target = new File(filepath + "/" + sysname);
				
				// 하드디스크에서 뽑아낸 타겟 파일 내용을 저장할 배열을 준비
				byte[] fileContents = new byte[(int)target.length()];
				
				try(	// 타겟 파일에 스트림을 연결 ( 데이터 통신 준비 )
						FileInputStream fis = new FileInputStream(target);
						DataInputStream dis = new DataInputStream(fis);
						// 클라이언트에게 데이터를 보낼 수 있는 스트림 개방
						ServletOutputStream sos = response.getOutputStream();
						){
					// 하드디스크에서 타겟 파일 내용을 RAM으로 복사
					dis.readFully(fileContents);
					//파일의 내용을 전송
					sos.write(fileContents);
					sos.flush();
				}
				System.out.println(target);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
