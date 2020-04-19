package javaStudy.practice;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePractice {

	public static void main(String[] args) {
		Queue queue = new LinkedList();
		
		queue.add(2);
		queue.add(3);
		queue.offer(5);
		queue.offer(4);
		queue.offer(1);
		
		//for(int i=0;i<queue.size();i++) {
		System.out.println("queue");
			while(!queue.isEmpty())
			System.out.println(queue.poll());
		//}
		
	}
}
