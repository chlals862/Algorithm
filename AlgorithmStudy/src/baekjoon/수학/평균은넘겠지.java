package baekjoon.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균은넘겠지 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int C = Integer.parseInt(br.readLine());

		while (C-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			double sum = 0;
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
			}
			double mean = sum / N;
			double cnt = 0;
			
			for(int i=0;i<N;i++) {
				if(arr[i] > mean) cnt++;
			}
			double res = (double) cnt / N * 100;
			System.out.printf("%.3f",res);
			System.out.println("%");
		}
	}

}
