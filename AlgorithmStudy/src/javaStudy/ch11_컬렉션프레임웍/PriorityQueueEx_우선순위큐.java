package javaStudy.ch11_컬렉션프레임웍;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx_우선순위큐 {
	/*
	 * 저장한 순서에 관계없이 우선순위가 높은 것부터 꺼냄
	 * null 저장불가
	 * 각 요소를 힙이라는 자료구조의 형태로 저장
	 * 
	 * */
	public static void main(String[] args) {
		
		Queue pq = new PriorityQueue();
		
		pq.offer(3);
		pq.offer(1);
		pq.offer(5);
		pq.offer(2);
		pq.offer(4);
		System.out.println(pq);
		
		Object obj = null;
		
		//PriorityQueue에 저장된 요소를 하나씩 꺼냄
		while((obj = pq.poll()) != null)
			System.out.println(obj);
	}
}
