package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 정열적인정렬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] K = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			K[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(K);
		for(int i=0;i<K.length;i++) {
			bw.write(K[i]+" ");
		}
		bw.flush();
		bw.close();
	}

}
