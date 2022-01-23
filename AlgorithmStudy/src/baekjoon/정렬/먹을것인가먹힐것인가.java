package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 먹을것인가먹힐것인가 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int a=0;a<T;a++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int[] arr1 = new int[A];
			int[] arr2 = new int[B];
			int result = 0;
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<A;i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<B;i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr2);
			for(int i=0;i<A;i++) {
				for(int j=B-1;j>=0;j--) {
					if(arr1[i]>arr2[j]) {
						result += j+1;
						break;
					}
				}
			}
			bw.write(result+"\n");
		}
		bw.flush();
		bw.close();
	}

}
