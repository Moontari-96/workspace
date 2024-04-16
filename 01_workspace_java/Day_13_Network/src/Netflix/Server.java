package Netflix;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import dao.MovieDAO;
import dto.MovieDTO;

public class Server {
	public static void main(String[] args) throws Exception {
		MovieDAO dao = new MovieDAO();
		ServerSocket server = new ServerSocket(25000);
		Socket sock = server.accept();
		System.out.println(sock.getInetAddress() + " 로 부터 접속");

		OutputStream os = sock.getOutputStream();
		DataOutputStream dos = new DataOutputStream(os);

		InputStream is = sock.getInputStream();
		DataInputStream dis = new DataInputStream(is);

		while (true) {
			int menu = dis.readInt();
			if (menu == 1) {
				String id = dis.readUTF();
				String title = dis.readUTF();
				String genre = dis.readUTF();
				// long ctime = dis.readLong();
				// SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
				// String date = sdf.format(ctime);
				String date = dis.readUTF();
				dao.addMoive(new MovieDTO(id, title, genre, date));
				dos.flush();
			} else if (menu == 2) {
				ArrayList<MovieDTO> movies = dao.getMovies();
				dos.writeInt(movies.size());
				for (int i = 0; i < movies.size(); i++) {
					dos.writeUTF(movies.get(i).getId());
					dos.writeUTF(movies.get(i).getTitle());
					dos.writeUTF(movies.get(i).getGenre());
					dos.writeUTF(movies.get(i).getWrite_date());
					dos.flush();
				}
//				for (int i = 0; i < movies.size(); i++) {
//					System.out.println(movies.get(i));
//					dos.writeUTF(movies.get(i).toString());
//					dos.flush();
//				}
			} else if (menu == 3) {
				String target = dis.readUTF();
				ArrayList<MovieDTO> movies = dao.searchMovie(target);
				dos.writeInt(movies.size());
				for (int i = 0; i < movies.size(); i++) {
					dos.writeUTF(movies.get(i).getId());
					dos.writeUTF(movies.get(i).getTitle());
					dos.writeUTF(movies.get(i).getGenre());
					dos.writeUTF(movies.get(i).getWrite_date());
					dos.flush();
				}
			} else if (menu == 4) {
				String target = dis.readUTF();
				dos.writeBoolean(dao.deleteMovie(target));
				dos.flush();
			} else if (menu == 5) {
				String id = dis.readUTF();
				String title = dis.readUTF();
				String genre = dis.readUTF();
				String date = dis.readUTF();
				MovieDTO dto = new MovieDTO(id, title, genre, date);
				boolean result = dao.modifyMovie(dto);
				dos.writeBoolean(result);
				dos.flush();
			}
		}

	}
}
