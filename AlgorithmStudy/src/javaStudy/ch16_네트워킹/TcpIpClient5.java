package javaStudy.ch16_네트워킹;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class TcpIpClient5 {

	public static void main(String[] args) {
		try {
			String serverIp = "127.0.0.1";
			//소켓을 생성해서 연결을 요청
			Socket socket = new Socket(serverIp,7778);
			
			System.out.println("서버에 연결 완료");
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
