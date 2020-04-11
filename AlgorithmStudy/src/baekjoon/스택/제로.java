package baekjoon.스택;

import java.util.Scanner;
import java.util.Stack;

/*나코더 기장 재민이는 동아리 회식을 준비하기 위해서 장부를 관리하는 중이다.
재현이는 재민이를 도와서 돈을 관리하는 중인데,
애석하게도 항상 정신없는 재현이는 돈을 실수로 잘못 부르는 사고를 치기 일쑤였다.
재현이는 잘못된 수를 부를 때마다 0을 외쳐서, 
가장 최근에 재민이가 쓴 수를 지우게 시킨다.
재민이는 이렇게 모든 수를 받아 적은 후 그 수의 합을 알고 싶어 한다.*/

/*정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.*/

public class 제로 {
	
	static int sum = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		Stack<Integer> stack = new Stack<Integer>();
		//0이면 pop, 0이아니면 push
		for(int i=0;i<input;i++) {
			int num = sc.nextInt();
			sc.nextLine();
			//System.out.println(stack);
			if(num != 0) {
				stack.push(num);
			}else if(num == 0) {
				stack.pop();
			}	
		}//for
		//스택이 비어있지 않으면 수행
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}//while
		System.out.println(sum);
	}
}
