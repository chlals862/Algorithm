package baekjoon.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class 괄호_ING {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int num;
	static int cnt;
	// static char[] ch = new char[100];
	public static void main(String[] args) throws NumberFormatException, IOException,EmptyStackException {

		int inputNum = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < inputNum; i++) {
			Stack<Character> stack = new Stack<Character>();
			String inputStr = br.readLine();

			for (int j = 0; j < inputStr.length(); j++) {
				char ch = inputStr.charAt(j);

				//step 1. 여는 괄호 -> 조건 없이 무조건 push가능
				if(ch=='(') {
					stack.push('(');
				}
				
				//step 2. 닫는 괄호 ->
				//1) stack이 비어있지 않아야함
				//2) 열린 괄호가 있으면 pop
				//비어있거나 )가 있을때는 pop을 하지 않아야함★★★★★
				if (ch == ')') {
					num++;
					//System.out.println("cnt = " + cnt);
					//System.out.println("num = " + num);
					if (stack.size() > 0 && stack.peek() == '(') {
						stack.pop();
						cnt++;
						//System.out.println("cnt = " + cnt);
						//System.out.println("num = " + num);
					}else if(stack.size() == 0 || stack.peek() == ')') {
						
					}
				}
				System.out.println("stack = " + stack);
			}

			if (cnt == num && stack.isEmpty()) {
				System.out.println("YES");
			} else if (cnt != num) {
				System.out.println("NO");
			}
		}

	}
}