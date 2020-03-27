package javaStudy.ch13_쓰레드;

/* 프로세스 -> 실행 중인 프로그램, 프로그램을 실행하면 OS로부터 실행에 필요한 자원(메모리)을 할당받아 프로세스가 됨
 * 쓰레드 -> 프로세스의 자원을 이용해서 실제로 작업을 수행하는 것
 * 
 * 멀티쓰레딩 장단점
 * -CPU의 사용률 향상
 * -자원을 보다 효율적으로 사용
 * -사용자에 대한 응답성이 향상
 * -작업이 분리되어 코드가 간결해짐
 * 
 * 교착상태 -> 두 쓰레드가 자원을 점유한 상태에서 서로 상대편이 점유한 자원을 사용하려고 기다리느라 진행이 멈춰있는 상태
 * 
 * 쓰레드 구현방법 2가지
 * 1. Thread클래스를 상속받음 -> 다른 클래스를 상속받을 수 없는 단점
 * 2. Runnable인터페이스를 구현(추천) -> 재사용성이 높고, 코드의 일관성을 유지할 수 있음
 * */
public class ThreadEx1 {

	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		//Runnable인터페이스를 구현한 경우, Runnable인터페이스를 구현한 클래스의 인스턴스를 생성한 후,이 인스턴스를 Thread클래스의 생성자의 매개변수로 제공해야 함
		Runnable r = new ThreadEx1_2(); 
		Thread t2 = new Thread(r); //생성자 Thread(Runnable target)
		
		t1.start();
		t2.start();
	}	
}

class ThreadEx1_1 extends Thread {
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(getName()); //조상인 Thread의 getName()을 호출
		}
	}
}

class ThreadEx1_2 implements Runnable {
	public void run() {
		for(int i=0;i<5;i++) { 
			//Thread.currentThread() -> 현재 실행중인 쓰레드를 반환
			System.out.println(Thread.currentThread().getName());
		}
	}
}