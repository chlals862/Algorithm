package baekjoon.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 괄호_ING {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	
	//static char[] ch = new char[100];
	public static void main(String[] args) throws NumberFormatException, IOException {

		int inputNum = Integer.parseInt(br.readLine());
	//	char ch;
		
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<inputNum; i++) {
			String inputStr = br.readLine();
			
			for(int j=0;j<inputStr.length();j++) {
				char ch = inputStr.charAt(j);
				
				if(ch == '(' || stack.isEmpty()) {
					stack.push(ch);

				} else if(!stack.isEmpty() && ch == ')') {
						stack.pop();
			}
			
		}
			if(stack.isEmpty() ) {
				System.out.println("YES");
			}else
				System.out.println("NO");
			}
	}
		
			//ch = inputStr.charAt(inputStr.length());
			//System.out.println(ch);
			//char ch[] = inputStr.toCharArray();
			//System.out.println("ch =  " + ch[i]);
			
			
			
			
//			if (ch == '(' || stack.empty()) {
//				stack.push(ch);
//			} else if (ch == ')') {
//				if (!stack.isEmpty()) {
//					stack.pop();
//				}
//			}
		//	System.out.println("stack = " + stack);
		//	if(stack.isEmpty() || ch[i] == '(' ) {
		//		stack.push(ch);
		//	}
			
			
		
			
		
			//System.out.print("ch = " + ch);
			
			  //if(inputStr.charAt(i) == '(' || stack.isEmpty()) {
				// stack.push();
			 // }
		

	}
