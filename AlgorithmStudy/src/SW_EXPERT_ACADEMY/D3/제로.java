package SW_EXPERT_ACADEMY.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class 제로 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			Stack<Integer> stack = new Stack<Integer>();
			int N = Integer.parseInt(br.readLine());
			while(N --> 0) {
				int num = Integer.parseInt(br.readLine());			
				
				if(num == 0 && stack.size() > 0) {
					stack.pop();
				}else {
					stack.push(num);
				}
			}
			int sum = 0;
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			bw.write("#"+i+" "+sum+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
