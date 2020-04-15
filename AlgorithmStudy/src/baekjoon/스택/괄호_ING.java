package baekjoon.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_ING {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// static char[] ch = new char[100];
	public static void main(String[] args) throws NumberFormatException, IOException {

		int inputNum = Integer.parseInt(br.readLine());
		
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < inputNum; i++) {
			String inputStr = br.readLine();

			for (int j = 0; j < inputStr.length(); j++) {
				char ch = inputStr.charAt(j);

				// 여는 괄호일때
				if (ch == '(') {
					stack.push('(');
				// 닫는 괄호일때
				}else if(ch == ')') {
					//여는 괄호를 pop함
					if(!stack.isEmpty())
						stack.pop();
				}
				
			}//j
		}//i
	}
}
