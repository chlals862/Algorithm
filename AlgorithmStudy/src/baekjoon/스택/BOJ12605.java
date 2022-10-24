package baekjoon.스택;

import java.util.Scanner;
import java.util.Stack;

public class BOJ12605 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<>();
		
		int t = sc.nextInt();
		sc.nextLine();
		
		for(int T=0;T<t;T++) {
			String str = sc.nextLine();
			String[] arr = str.split(" ");
			
			for(int i=0;i<arr.length;i++) {
				stack.push(arr[i]);
			}
			sb.append("Case #" + (T+1) + ": ");
			
			for(int i=0;i<arr.length;i++) {
				sb.append(stack.pop()).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
