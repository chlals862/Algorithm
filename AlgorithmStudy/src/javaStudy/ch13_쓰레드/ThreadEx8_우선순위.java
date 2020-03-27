package javaStudy.ch13_쓰레드;

public class ThreadEx8_우선순위 {
	/*
	 * void setPriority(int newPriority) -> 쓰레드의 우선순위를 지정한 값으로 변경
	 * int getPriority()                 -> 쓰레드의 우선순위를 반환
	 * 
	 * main메서드를 수행하는 쓰레드는 우선순위가 5이므로 
	 * main메서드내에서 생성하는 쓰레드의 우선순위는 자동적으로 5가 됨
	 * 숫자가 높으면 높을 수록 우선순위가 높음★★★
	 * 
	 * */
	public static void main(String[] args) {
		ThreadEx8_1 th1 = new ThreadEx8_1();
		ThreadEx8_2 th2 = new ThreadEx8_2();
		
		th2.setPriority(7);
		
		System.out.println("Priority of th1(-) : " + th1.getPriority());
		System.out.println("Priority of th2(|) : " + th2.getPriority());
		th1.start();
		th2.start();
	}
}

class ThreadEx8_1 extends Thread {
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("-");
			for(int x=0;x<10000000;x++);
		}
	}
}
class ThreadEx8_2 extends Thread {
	public void run() {
		for(int i=0;i<300;i++) {
			System.out.print("|");
			for(int x=0;x<10000000;x++);
		}
	}
}