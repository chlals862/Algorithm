package javaStudy.ch13_쓰레드;
	/*
	 * 데몬쓰레드 -> 다른 일반 쓰레드(데몬 쓰레드가 아닌 쓰레드)의 작업을 돕는 보조적인 역할을 수행하는 쓰레드
	 * 데몬쓰레드 예) -> 가비지 컬렉터, 워드프로세서의 자동저장, 화면자동갱신 등
	 * 
	 * 데몬 쓰레드는 일반 쓰레드의 작성방법과 실행방법이 같음
	 * 하지만 쓰레드를 생성한 다음 실행하기 전에 setDaemon(true)를 호출을 해야함
	 * 데몬 쓰레드가 생성한 쓰레드는 자동적으로 데몬 쓰레드가 됨
	 * 
	 * */
public class ThreadEx10_데몬쓰레드 implements Runnable{
	static boolean autoSave = false;
	public static void main(String[] args) {

		Thread t = new Thread(new ThreadEx10_데몬쓰레드());
		t.setDaemon(true);
		t.start();
		
		for(int i=1;i<=10;i++) {
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
				System.out.println(i);
				if(i==5)
					autoSave = true;
		}
			System.out.println("프로그램 종료!");
		
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(3* 1000);
			} catch (Exception e) {}
			//autoSave의 값이 true이면 autoSave()호출
			if(autoSave) {
				autoSave();
			}
		}
	}	

	public void autoSave() {
		System.out.println("작업파일이 자동저장!");
	}
}

