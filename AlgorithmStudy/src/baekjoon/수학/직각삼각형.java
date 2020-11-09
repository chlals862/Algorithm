package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class 직각삼각형 {
	static int A,B,C,max;
	static int[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			arr = new int[3];
			arr[0] = A; arr[1] = B; arr[2] = C;
			Arrays.sort(arr);
			int a = arr[0]*arr[0]; int b = arr[1]*arr[1]; int c = arr[2]*arr[2];
			if(a+b == c) bw.write("right"+"\n");
			else bw.write("wrong"+"\n");
			if(A == 0 && B == 0 && C == 0 ) return;
			bw.flush();
		}
	}
}
