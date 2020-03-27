package javaStudy.ch13_쓰레드;
/*
 * ThreadGroup -> 서로 관련된 쓰레드를 그룹으로 다루기 위한 것
 * Ex) -> 폴더를 생성하여 관련된 파일을 함꼐 넣어서 관리하는 것
 * 
 * 폴더안에 다른 폴더를 넣을 수 있듯이 쓰레드 그룹안에 다른 쓰레드그룹을 포함시킬 수 있음★★★★★
 * 
 * 자신이 속한 쓰레드 그룹이나 하위 쓰레드 그룹은 변경 O
 * 다른 쓰레드 그룹의 쓰레드는 변경 불가능 X
 * 우리가 생성하는 모든 쓰레드 그룹은 main쓰레드 그룹의 하위 쓰레드 그룹이 됨
 * 쓰레드 그룹을 지정하지 않고 생성한 쓰레드는 자동적으로 main쓰레드 그룹에 속하게 됨
 * 
 * P741
 * 쓰레드를 쓰레드 그룹에 포함시키려면 Thread의 생성자를 이용해야 함
 * */
public class ThreadEx9_쓰레드그룹 {
//ThreadGroup gtThreadGroup() -> 쓰레드 자신이 속한 쓰레드 그룹을 반환
	
	//--------쓰레드 그룹과 쓰레드를 생성하고 main.list()를 호출해서 main쓰레드 그룹의 정보를 출력하는 예제--------
	public static void main(String[] args) throws Exception {

		ThreadGroup main = Thread.currentThread().getThreadGroup(); // 쓰레드 name = main , maxpriority = 10;
		// System.out.println(main);
		ThreadGroup grp1 = new ThreadGroup("Group1");
		ThreadGroup grp2 = new ThreadGroup("Group2");
		
		//ThreadGroup(ThreadGroup parent, String name)
		ThreadGroup subgrp1 = new ThreadGroup(grp1, "SubGroup1");

		grp1.setMaxPriority(3);

		Runnable r = new Runnable() {

			public void run() {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		//Thread(ThreadGroup tg, Runnable r, String name)
		new Thread(grp1, r, "th1").start();
		new Thread(subgrp1, r, "th2").start();
		new Thread(grp2, r, "th3").start();
		
		System.out.println(">>List of ThreadGroup : " + main.getName() + ", Active ThreadGroup : " + main.activeGroupCount() + ", Active Thread : " + main.activeCount()); 
		main.list();
		
	}
}
