package 코딩테스트.라인_2020;

import java.util.Scanner;
import java.util.Stack;

public class Line_CodingTest1_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();

		Stack<Integer> stack = new Stack<Integer>();

		int result = 0;

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '<') {

				stack.push(1);
				result += 1;
				System.out.println("input result = " + result);

			} else if (input.charAt(i) == ')' || input.charAt(i) == '}' || input.charAt(i) == ']' || input.charAt(i) == '>') {
				//stack.push(-1);
				result -= 1;
				System.out.println("output result = " + result);
			
			
			if(stack.isEmpty() || stack.peek() >= 0) {
				result = -1;
			} else if(result == 0) {
				stack.pop();
				result++;
			}
			
			}
		} // for
			System.out.println("result = " + result);
	}

}