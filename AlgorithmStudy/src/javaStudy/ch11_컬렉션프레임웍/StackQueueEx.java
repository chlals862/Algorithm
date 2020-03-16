package javaStudy.ch11_컬렉션프레임웍;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueEx {

	public static void main(String[] args) {
		Stack st = new Stack();
		Queue q = new LinkedList(); //Queue인터페이스의 구현체인 LinkedList를 사용
		
		st.push("0");
		st.push("1");
		st.push("2");
		
		q.offer("0");
		q.offer("1");
		q.offer("2");
		
		System.out.println("= Stack =");
		while(!st.empty()) { //스택이 비어있지 않을때 pop(꺼내기)수행
			System.out.println(st.pop()); //스택은 LIFO이므로  결과 : 2 1 0
		}
		System.out.println("= Queue =");
		while(!q.isEmpty()) { //큐가 비어있지 않을떄 poll(꺼내기)수행
			System.out.println(q.poll()); //큐는 FIFO이므로 결과 : 0 1 2 
		}
	}
}
