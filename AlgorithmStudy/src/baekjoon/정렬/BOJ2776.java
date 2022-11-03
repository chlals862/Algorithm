package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2776 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while(T --> 0) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());	
			}
			Arrays.sort(arr);
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<M;i++) {
				int num = Integer.parseInt(st.nextToken());
				if(Arrays.binarySearch(arr, num) < 0) {
					sb.append("0\n");
				}else {
					sb.append("1\n");
				}
			}
			
		}
		bw.write(sb+"");
		br.close();
		bw.flush();
		bw.close();
	}
}
