package 코딩테스트.라인_2020;

import java.util.Scanner;
import java.util.Stack;

public class Line_CodingTest1_2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int result = 0;
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < input.length(); i++) {

			if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '<') {

				stack.push(1);
				result += 1;
				System.out.println("input result = " + result);

			} else if (input.charAt(i) == ')' || input.charAt(i) == '}' || input.charAt(i) == ']'
					|| input.charAt(i) == '>') {
				result -= 1;
				System.out.println("output result = " + result);
				System.out.println("stack = " + stack);

			} else
				stack.pop();
			result++;

		} // for
		if (result < 0) {
			result = -1;

		}
		System.out.println("result = " + result);
	}

}