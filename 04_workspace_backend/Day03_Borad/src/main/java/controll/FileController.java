package controll;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.FilesDAO;
import dto.FilesDTO;

@WebServlet("*.file")
public class FileController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		System.out.println(cmd);
		FilesDAO dao = FilesDAO.getInstance();
		try {
			if(cmd.equals("/download.file")) {
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
