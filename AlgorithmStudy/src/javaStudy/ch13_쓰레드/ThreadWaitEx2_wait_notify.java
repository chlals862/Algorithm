package javaStudy.ch13_쓰레드;

import java.util.ArrayList;

/*
	 * wait() -> 호출시 실행 중이던 쓰레드는 해당 객체의 대기실(waiting pool)에서 통지를 기다림
	 * notify() -> 호출시 해당 객체의 대기실에 있던 모든 쓰레드 중에서 임의의 쓰레드만 통지를 받음
	 * notifyAll() -> 기다리고 있는 모든 쓰레드에게 통보를 하지만
	 * lock을 얻을 수 있는것은 하나의 쓰레드일 뿐이고 나머지 쓰레드는 통보를 받긴 했지만,
	 * lock을 얻지 못하면 다시 lock을 기다림
	 * 
	 * 매개변수가 있는 wait()은 지정된 시간동안만 기다림 -> 지정된 시간이 지난 후에 자동적으로 notify()가 호출되는것과 같음
	 * ---------------------------------------------------------------------------------
	 * wait(),notify(),notifyAll() -> 특정 객체에 대한 것이므로 Object클래스에 정의되어 있음
	 * 1. Object에 정의됨
	 * 2. 동기화 블록(synchronized블록)내에서만 사용 가능
	 * 3. 보다 효율적인 동기화를 가능하게 함
	 * */
class Customer implements Runnable {
	private Table table;
	private String food;
	
	Customer(Table table, String food) {
		this.table = table;
		this.food = food;
	}
	
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {}
			String name = Thread.currentThread().getName();
			
			if(eatFood())
				System.out.println(name + " ate a " + food);
			else
				System.out.println(name + " failed to eat. : (");
		}
	}
	boolean eatFood() {
		return table.remove(food);
	}
}

class Cook implements Runnable {
	private Table table;
	
	Cook(Table table) {
		this.table = table;
	}
		public void run() {
		while(true) {
		
			int idx = (int)(Math.random() * table.dishNum());
			table.add(table.dishNames[idx]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}
	}
}

class Table {
	String[] dishNames = {"donut","donut","burger"};
	final int MAX_fOOD = 6;
	private ArrayList<String> dishes = new ArrayList<>();
	
	public synchronized void add(String dish) {
		if(dishes.size() >= MAX_fOOD) 
			return;
		dishes.add(dish);
		System.out.println("Dishes : " + dishes.toString());
}

	public boolean remove(String dishName) {
		synchronized (this) {
			while (dishes.size() == 0) {
				String name = Thread.currentThread().getName();
				System.out.println(name + " is waiting.");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {}
			}
			for (int i = 0; i < dishes.size(); i++) 
				if (dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
		}
		return false;
	}
	public int dishNum() {
		return dishNames.length;
	}
}//table

	class ThreadWaitEx2_wait_notify {
	public static void main(String[] args) throws Exception{
		Table table = new Table(); //여러 쓰레드가 공유하는 객체
		
		new Thread(new Cook(table), "COOK1").start();
		new Thread(new Customer(table, "donut"), "CUST1").start();
		new Thread(new Customer(table, "burger"), "CUST2").start();
		
		Thread.sleep(5000);
		System.exit(0);
	}
}
