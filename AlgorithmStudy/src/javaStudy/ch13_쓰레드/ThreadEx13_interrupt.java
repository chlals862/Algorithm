package javaStudy.ch13_쓰레드;

import javax.swing.JOptionPane;

/*
 * interrupt() & interrupted() -> 쓰레드의 작업을 취소
 * interrupt()가 호출되지 않았다면 -> false
 * 			     가 호출되었다면        -> true
 * */
public class ThreadEx13_interrupt{
	
	public static void main(String[] args) throws Exception{
		ThreadEx13_1 th1 = new ThreadEx13_1();
		
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무값이나 입력");
		System.out.println("입력한 값은 : " + input);
		th1.interrupt(); //interrupt()를 호출하면 -> interrupted상태가 true가 됨
		System.out.println("isInterrupted : " + th1.isInterrupted());//true
	}
}
class ThreadEx13_1 extends Thread {
	public void run() {
		int i = 10;
		
		while(i != 0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x=0;x<2500000000L;x++); //시간지연
		}
		System.out.println("카운트가 종료!");
	}
}