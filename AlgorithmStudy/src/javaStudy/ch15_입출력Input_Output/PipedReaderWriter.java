package javaStudy.ch15_입출력Input_Output;

import java.io.PipedReader;
import java.io.PipedWriter;
import java.io.StringWriter;

public class PipedReaderWriter {
	/*
	 * PipedReader/PipedWriter -> 쓰레드 간에 데이터를 주고받을 때 사용
	 * 다른 스트림과는 달리 입력과 출력스트림을 하나의 스트림으로 연결해서 데이터를 주고 받음
	 * --------------------------------------------------------
	 * 두 쓰레드가 PipedReader/PipedWriter를 이용해서 서로 메시지를 주고받는 예제
	 * 
	 * ★★★★★ 쓰레드를 시작하기 전에 PipedReader와 PipedWriter를 연결해야 함
	 * */
	
	public static void main(String[] args) {
		InputThread inThread = new InputThread("InputThread");
		OutputThread outThread = new OutputThread("OutputThread");
		
		inThread.connect(outThread.getOutput());
		
		inThread.start();
		outThread.start();
	}
}
	//StringReader|StringWriter -> 문자열을 스트림에 기록하거나 읽어낼 때 사용
	class InputThread extends Thread {
		PipedReader input = new PipedReader();
		StringWriter sw = new StringWriter();
		
		InputThread(String name) {
			super(name); //Thread(String name);	
		}
		
		public void run() {
			try {
				int data = 0;
				
				while((data = input.read()) != -1) {
					sw.write(data);
				}
				System.out.println(getName() + " received = " + sw.toString());
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}//run
		
		public PipedReader getInput() {
			return input;
		}
		
		public void connect(PipedWriter output) {
			try {
				input.connect(output);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}//connect
	}
	
	
	//====================================================================================
	
	
	class OutputThread extends Thread {
		PipedWriter output = new PipedWriter();
		
		OutputThread(String name) {
			super(name); //Thread(String name);
		}
		
		public void run() {
			try {
				String msg = "Hello";
				System.out.println(getName() + " sent = " + msg);
				output.write(msg);
				output.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}//run
		
		public PipedWriter getOutput() {
			return output;
		}
		public void connect(PipedReader input) {
			try {
				output.connect(input);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
