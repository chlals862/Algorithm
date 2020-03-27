package javaStudy.ch13_쓰레드;
	/*
	 * join() -> 다른 쓰레드의 작업을 기다림
	 * 쓰레드 자신이 하던 작업을 잠시 멈추고 다른 쓰레드가 지정된 시간동안 작업을 수행하도록 할 떄 사용
	 * 
	 * */
public class ThreadEx20__Join {
	/*
	 * JVM의 가비지 컬렉터를 흉내 내어 간단히 구현해 본 예제
	 * 먼저 sleep()을 이용해서 10초마다 한 번씩 가비지 컬렉션을 수행하는 쓰레드를 만든 당,ㅁ
	 * 쓰레드를 생성해서 데몬 쓰레드로 설정하였다.
	 * */
	public static void main(String[] args) {
		ThreadEx20_1 gc = new ThreadEx20_1();
		
		gc.setDaemon(true);
		gc.start();
		
		int requiredMemory = 0;
		
		for(int i=0;i<20;i++) {
			requiredMemory = (int)(Math.random() * 10) * 20;
			
			// 필요한 메모리가 사용할 수 있는 양보다 크거나 전체 메모리의 60% 이상을 사용했을 경우 gc를 꺠움
			if(gc.freeMemory() < requiredMemory || gc.freeMemory() < gc.totalMemory() * 0.4) {
				gc.interrupt(); //gc꺠우기
			}
			gc.usedMemory += requiredMemory;
			System.out.println("usedMemory : " + gc.usedMemory);
		}//for
	}//main
}//public class

class ThreadEx20_1 extends Thread {
	final static int MAX_MEMORY = 100;
	int usedMemory = 0;

	public void run() {//반복문을 사용해서 메모리의 양을 계속 감소시키도록 했고, 매 반복마다 if문으로 메모리를 확인해서
					   //남은 메모리가 전체메모리의 40% 미만일 경우 interrupt()를 호출해서,
		               //즉시 가비지 컬렉터 쓰레드를 깨워서 gc()를 수행하도록 함
		while(true) {
			try {
				Thread.sleep(10 * 1000); //10초 대기
			} catch (Exception e) {
				System.out.println("Awaken by interrupt().");
			}
			gc();
			System.out.println("Garbage Collected. Free Memory : " + freeMemory());
		}//while
	}//run()
	
	public void gc() {
		usedMemory -= 300;
		if(usedMemory < 0) 
			usedMemory =0;
	}
	
	public int totalMemory() {
		return MAX_MEMORY;
	}
	
	public int freeMemory() {
		return MAX_MEMORY - usedMemory;
	}
}//end of class

