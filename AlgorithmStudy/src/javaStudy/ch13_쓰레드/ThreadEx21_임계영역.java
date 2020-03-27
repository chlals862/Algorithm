package javaStudy.ch13_쓰레드;
	/*
	 * 쓰레드의 동기화 -> 한 쓰레드가 진행 중인 작업을 다른 쓰레드가 간섭하지 못하도록 막는 것
	 * 1.synchronized를 이용한 동기화
	 * synchronized를 붙이면 메서드 전체가 임계 영역으로 설정됨
	 * ex) -> public synchronized void 메서드명() { 임계 영역 }
	 * --------------------------------------------------------------
	 * 2.메서드 내의 일부를 블럭{}으로 감싸고 블럭 앞에 'synchronized(참조변수)'를 붙이는 것
	 * ex) -> synchronized(객체의 참조변수) { 임계영역 }
	 * */
public class ThreadEx21_임계영역 {
	/*
	 * 은행계좌의 잔고를 확인하고 임의의 금액을 출금하는 예제
	 * 
	 * */
	public static void main(String[] args) {
		Runnable r = new RunnableEx21();
		new Thread(r).start(); // ThreadGroup에 의해 참조되므로 gc대상이 아님
		new Thread(r).start();
	}
}

class Account {
	private int balance = 1000;

	public int getBalance() {
		return balance;
	}

	public void withdraw(int money) {
		synchronized (this) {
			if (balance >= money) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				balance -= money;
			}
		}
	}
}

class RunnableEx21 implements Runnable {
	Account acc = new Account();

	public void run() {
		while (acc.getBalance() > 0) {
			// 100,200,300중 한 값을 임의로 선택해서 출금(withdraw)
			int money = (int) (Math.random() * 5 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance : " + acc.getBalance());
		} // while
	}// run
}// class