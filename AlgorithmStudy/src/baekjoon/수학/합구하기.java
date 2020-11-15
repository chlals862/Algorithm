package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 합구하기 {
	static int N,num,start,end;
	static int[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int row=1;row<=N;row++) {
			arr[row] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		num = Integer.parseInt(st.nextToken());
		for(int row=0;row<num;row++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			for(int i=start;i<=end;i++) {
				sum+=arr[i];
			}
			bw.write(sum+"\n");
		}
		bw.flush();
		bw.close();
	}
}
