package baekjoon.스택;

import java.util.Scanner;
import java.util.Stack;

/*정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.*/

//첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 
//둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 
//문제에 나와있지 않은 명령이 주어지는 경우는 없다.

public class 스택 {
	static int st[] = new int[10001];
	static int top = -1;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		//push , pop, empty, top, size를 입력하면 해당하는 메서드 실행 -> 문자
		
		
		
		if (N >= 1 && N <= 10000) {
		for (int i = 0; i < N; i++) {
		//nextLine으로 하면 "push 1"을 한번에 읽으므로 구분 불가능
		String input = sc.next();
		  switch(input) {
		  
		  case "push" : 
			  int num = sc.nextInt(); //push는 int가 들어가기 때문에 int를 읽어야하므로 nextInt사용
			  push(num);
		  break;
		  
		  //맨위에 있는값 뽑기 -> 스택은 LIFO st[top]의 위치를 뽑으면 됨 그 전에 일단 비어있는지, top이 -1인지 확인해보자(메서드에서)
		  case "pop" :
			  pop();
			  break;
		  case "top" :
			  top();
			  break;
		  case "size" :
			  size();
			  break;
		  case "empty" :
			  empty();
			  break;
				}//switch
			} // for
		} // if

	}// main
	
	//push입력시
	private static void push(int num) {
		if(top < 10000) {
			//top의 위치가 배열의 크기를 벗어나지 않는다면 push를 할 수 있기 때문에 top++로 위치를 변경시켜주고
			//st[]배열의 top위치에 해당 값을 넣음
			top++;
			st[top] = num;
			
		}else if(top > 10000) {
			return;
		}
		
	}
	//pop은 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	private static void pop() {
		//top이 -1이 아니거나 top이 10000미만일때 수행
		if(top != -1) {
			System.out.println(st[top]);
			top--;
		}else if(top == -1) {
			System.out.println(-1);
		}
	}
	
	//top()은 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
	private static void top() {
		//top -> -1이면 배열에 값이 없음  -> index는 0부터 시작 ->1번쨰
		if(top != -1) {
			System.out.println(st[top]);
		}else if(top == -1) {
			System.out.println(-1);
		}
	}
	//스택에 들어있는 정수의 개수를 출력한다.
	private static void size() {
		if(top != -1) {
			System.out.println(top+1);
		}else if(top == -1) {
			System.out.println(0);
		}
	}
	//스택이 비어있으면 1, 아니면 0을 출력한다.
	private static void empty() {
		if(top == -1) {
			System.out.println(1);
		}else if(top != -1) {
			System.out.println(0);
		}
	}
	
}