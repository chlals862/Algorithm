package baekjoon.스택;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 괄호 {
	static int count;
	static int T;
	static Stack<String> stack;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int testCase=0;testCase<T;testCase++) {
			stack = new Stack<String>();
			String sLine = br.readLine();
			String[] sArr = new String[sLine.length()];
			sArr = sLine.split("");
			count = 0;

			for(int j=0;j<sLine.length();j++) {
				if(sArr[j].equals("(")) {
					stack.push(sArr[j]);
					count++;
				} else {
					
					if(stack.isEmpty()) {
						continue;
					} else {
						stack.pop();
						count++;
					}
				}
			}
			if(sLine.length() == count && stack.isEmpty()) {
				bw.write("YES"+"\n");
			}else if(sLine.length() != count || !stack.isEmpty()){
				bw.write("NO"+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
