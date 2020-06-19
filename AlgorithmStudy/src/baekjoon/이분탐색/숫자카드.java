package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 숫자카드 {
	static int N,M;
	static HashSet<Integer> A;
	static int[] B;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		for(int row=0;row<M;row++) {
			if(A.contains(B[row])) {
				bw.write(1+" ");
			}else {
				bw.write(0+" ");
			}
		}
		bw.flush();
		bw.close();
	}
	private static void setData() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		A = new HashSet<Integer>();
		for(int row=0;row<N;row++) {
			A.add(Integer.parseInt(st.nextToken()));
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		B = new int[M];
		
		for(int row=0;row<M;row++) {
			B[row] = Integer.parseInt(st.nextToken());
		}
	}
}
