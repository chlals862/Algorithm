package javaStudy.ch13_쓰레드;
	/*
	 * 병행 -> 여러 쓰레드가 여러 작업을 동시에 진행하는 것
	 * 병렬 -> 하나의 작업을 여러 쓰레드가 나눠서 처리하는 것
	 * */
public class ThreadEx5_싱글_멀티쓰레드 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();
		startTime = System.currentTimeMillis();
		
		for(int i=0;i<300;i++)
			System.out.printf("%s", new String("-"));
		System.out.print("소요시간1 : " + (System.currentTimeMillis() - ThreadEx5_싱글_멀티쓰레드.startTime));
	}
}

class ThreadEx5_1 extends Thread {
	public void run() {
		for(int i=0;i<300;i++) 
			System.out.printf("%s", new String("|"));
		
		System.out.print("소요시간2 : " + (System.currentTimeMillis() - ThreadEx5_싱글_멀티쓰레드.startTime));
	}
}