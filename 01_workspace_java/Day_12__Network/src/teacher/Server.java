package teacher;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;

public class Server {
	public static void main(String[] args) throws Exception {

		int[] lotto = new int[45];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1;
		}

		String[] wisewords = new String[] {
				"Learning without thought is labor lost; thought without learning is perilous.",
				"It is the mark of an educated mind to be able to entertain a thought without accepting it.",
				"The superior man is modest in his speech, but excels in his actions." };

		ServerSocket server = new ServerSocket(25000);
		System.out.println("사용자 접속을 대기 중 입니다..");
		Socket socket = server.accept();
		System.out.println(socket.getInetAddress() + " 로 부터 접속");
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

		while (true) {
			int menu = dis.readInt();

			if (menu == 1) {

				for (int i = 0; i < lotto.length * 10; i++) {
					int x = (int) (Math.random() * 45);
					int y = (int) (Math.random() * 45);
					int tmp = lotto[x];
					lotto[x] = lotto[y];
					lotto[y] = tmp;
				}

				String result = "";
				for (int i = 0; i < 7; i++) {
					result += lotto[i] + " ";
				}

				dos.writeUTF(result);
				dos.flush();

			} else if (menu == 2) {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd(E) hh:mm:ss");
				String result = sdf.format(System.currentTimeMillis());
				dos.writeUTF(result);
				dos.flush();

			} else if (menu == 3) {

				String result = wisewords[(int) (Math.random() * 3)];
				dos.writeUTF(result);
				dos.flush();

			}

		}

	}
}
