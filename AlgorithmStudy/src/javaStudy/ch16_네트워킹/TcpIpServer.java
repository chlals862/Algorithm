package javaStudy.ch16_네트워킹;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TcpIpServer {
	/*
	 * 간단한 TCP/IP서버를 구현한 예제
	 * 이 예제 실행시 서버소켓이 7777번 포트에서 클라이언트 프로그램의 연결을 기다림
	 * */
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//서버소켓을 생성하여 7777번 포트와 결합(bind)시킨다.
			serverSocket = new ServerSocket(7777);
			System.out.println(getTime() + " 서버 준비완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(true) {
			try {
				System.out.println(getTime() + "연결요청을 기다림");
				//서버소켓은 클라이언트의 연결요청이 올 때까지 실행을 멈추고 계속 기다림
				//클라이언트의 연결요청이 오면 클라이언트 소켓과 통신할 새로운 소켓을 생성
				Socket socket = serverSocket.accept();
				System.out.println(getTime() + socket.getInetAddress() + "로부터 연결요청이 들어옴");
				
				//소켓의 출력스트림을 얻음
				OutputStream out = socket.getOutputStream();
				DataOutputStream dos = new DataOutputStream(out);
				
				//원격소켓(remote socket)에 데이터를 보냄
				dos.writeUTF("[Notice] Test Message1 from Server.");
				System.out.println(getTime() + "데이터를 전송함");
				
				//스트림과 소켓을 닫음
				dos.close();
				socket.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}//while
	}
	//현재시간을 문자열로 반환하는 함수
	static String getTime() {
		SimpleDateFormat f = new SimpleDateFormat("[hh:mm:ss]");
		return f.format(new Date());
	}
}
