package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 수정렬하기4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[2000001];
		for(int row=0;row<N;row++) {
			int num = Integer.parseInt(br.readLine());
			arr[num+1000000]++;
		}
		for(int row=2000000;row>=0;row--) {
			for(int col=0;col<arr[row];col++) {
				bw.write((row-1000000)+"\n");
			}
		}
		bw.flush();
		bw.close();
	}
}
