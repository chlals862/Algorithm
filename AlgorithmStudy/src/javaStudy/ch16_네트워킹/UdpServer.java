package javaStudy.ch16_네트워킹;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpServer {
	public void start() throws IOException {
		
		//포트 7779번을 사용하는 소켓을 생성
		DatagramSocket socket = new DatagramSocket(7779);
		DatagramPacket inPacket, outPacket;
		
		byte[] inMsg = new byte[10];
		byte[] outMsg;
	
		while(true) {
			//데이터를 수신하기 위한 패킷을 생성
			inPacket = new DatagramPacket(inMsg, inMsg.length);
			
			//패킷을 통해 데이터를 수신(receive)함
			socket.receive(inPacket);
			
			//수신한 패킷으로부터 client의 IP주소와 Port를 얻음
			InetAddress address = inPacket.getAddress();
			int port = inPacket.getPort();
			
			//서버의 현재 시간을 시분초 형태로 반환
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String time = sdf.format(new Date());
			outMsg = time.getBytes(); //time을 byte배열로 반환
			
			//패킷을 생성해서 client에 전송(send)함
			outPacket = new DatagramPacket(outMsg, outMsg.length, address, port);
			socket.send(outPacket);
			
		}//while
	}//start
	public static void main(String[] args) {
		try {
			//UDP서버를 실행
			new UdpServer().start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
