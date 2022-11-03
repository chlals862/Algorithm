package baekjoon.누적합;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ10211 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			int max = Integer.MIN_VALUE;
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N+1];
			int[] sub = new int[N+1];
			st = new StringTokenizer(br.readLine());
			
			for(int row=1;row<=N;row++) {
				arr[row] = Integer.parseInt(st.nextToken());
				sub[row] = sub[row-1] + arr[row];
				//System.out.println("arr[row] = " + arr[row]);
				//System.out.println("sub[row] = " + sub[row] );
				max = Math.max(arr[row], sub[row]);
				//System.out.println("max = " + max);
				//System.out.println(arr[row] + " ??");
			}
			
			for(int row=0;row<=N;row++) {
				for(int col=N;col>row;col--) {
					max = Math.max(max, sub[col]-sub[row]);
					//System.out.println("sub[row] = " + sub[row]);
					//System.out.println("sub[col] = " + sub[col]);
				}
			}
			bw.write(max+"\n");
			
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
