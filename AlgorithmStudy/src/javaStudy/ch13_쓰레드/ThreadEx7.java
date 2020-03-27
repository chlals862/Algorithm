package javaStudy.ch13_쓰레드;

import javax.swing.JOptionPane;

public class ThreadEx7 {

	public static void main(String[] args) {
	
		ThreadEx7_1 th1 = new ThreadEx7_1();
		th1.start();
		
		String input = JOptionPane.showInputDialog("아무 값이나 입력");
		System.out.println("입력한 값은" + input);
	}
}



class ThreadEx7_1 extends Thread {
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
