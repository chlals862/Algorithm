package javaStudy.ch13_쓰레드;
	/*
	 * suspend() -> sleep()처럼 쓰레드를 멈추게함
	 * suspend()에 의해 정지된 쓰레드는 resume()을 호출해야 다시 실행대기 상태가 됨
	 * stop() -> 호출되는 즉시 쓰레드가 종료
	 * */
public class ThreadEx15 {

	public static void main(String[] args) {
		RunInplEx15 r = new RunInplEx15();
		Thread th1 = new Thread(r, "*");
		Thread th2 = new Thread(r, "**");
		Thread th3 = new Thread(r, "***");
		th1.start();
		th2.start();
		th3.start();
		
		try {
			Thread.sleep(2000);
			th1.suspend(); //쓰레드1 잠시 중단
			Thread.sleep(2000);
			th2.suspend();
			Thread.sleep(3000);
			th1.resume();//th1 다시동작
			Thread.sleep(3000);
			th1.stop();
			th2.stop();
			Thread.sleep(2000);
			th3.stop();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
class RunInplEx15 implements Runnable {
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
