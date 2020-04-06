package javaStudy.ch16_네트워킹;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
	 * UDP -> DatagramSocket , DatagramPacket을 사용
	 * UDP는 연결지향적인 프로토콜이 아니기 때문에 ServerSocket이 필요하지 않음
	 * UDP통신에서 사용하는 소켓은 DatagramSocket이며 데이터를 DatagramPacket에 담아서 전송함
	 * DatagramPacket은 헤더와 데이터로 구성되어 있음
	 * */
public class UdpClient {

	public void start() throws IOException, UnknownHostException {
		DatagramSocket datagramSocket = new DatagramSocket();
		InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
		
		//데이터가 저장될 공간으로 byte배열을 생성
		byte[] msg = new byte[100];
		
		DatagramPacket outPacket = new DatagramPacket(msg, 1, serverAddress, 7779);
		DatagramPacket inPacket = new DatagramPacket(msg, msg.length);
		
		datagramSocket.send(outPacket);//DatagramPacket을 전송함
		datagramSocket.receive(inPacket); //DatagramPacket을 수신함
		
		System.out.println("current server time = " + new String(inPacket.getData()));
		datagramSocket.close();
	}//start
	public static void main(String[] args) {
		try {
			new UdpClient().start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
