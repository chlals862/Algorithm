package baekjoon.스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class 스택수열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		//Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		ArrayList<String> list = new ArrayList<String>();
		int num = Integer.parseInt(st.nextToken());
		int[] arr = new int[num];
		int idx = 0;
		for(int i=0;i<num;i++) arr[i] = Integer.parseInt(br.readLine());
		for(int i=1;i<=num;i++) {
			stack.push(i);
			list.add("+");
		while(!stack.isEmpty()) {
			if(stack.peek() == arr[idx]) {
				stack.pop();
				list.add("-");
				idx++;
			} else {
				break;
			}
		}
	}
		if(!stack.isEmpty()) {
			bw.write("NO"+"\n");
		} else {
			for(String st : list) {
				bw.write(st+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
