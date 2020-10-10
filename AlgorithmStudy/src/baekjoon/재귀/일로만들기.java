package baekjoon.재귀;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 일로만들기 {
	static int num,min,cnt;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		num = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		dfs(num,0);
		bw.write(min+"\n");
		bw.flush();
		bw.close();
	}
	private static void dfs(int num, int cnt) {
		if(num==1) {
			if(min > cnt) {
				min = cnt;
			}else min = min;
			return;
		}
		if(cnt >= min) return;
		if(num % 3 ==0) {
			dfs(num/3,cnt+1);
		}
		if(num % 2 ==0) {
			dfs(num/2,cnt+1);
		}
		dfs(num-1,cnt+1);
		
	}
}
