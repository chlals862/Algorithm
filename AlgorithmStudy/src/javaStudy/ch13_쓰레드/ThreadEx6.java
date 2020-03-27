package javaStudy.ch13_쓰레드;

import javax.swing.JOptionPane;

public class ThreadEx6 {

	public static void main(String[] args) throws Exception{
		String input = JOptionPane.showInputDialog("아무 값이나 입력");
		System.out.println("입력한 값은 " + input);
		
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
