package baekjoon.그리디알고리즘;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 동전0 {
	static int[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int res = 0;
		arr = new int[N];
		
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(br.readLine());
		//가장 높은 동전부터 검섹
		for(int i=N-1;i>=0;i--) {
			if(arr[i] <= K) {
				res += K/arr[i]; //나눈 값이 해당 동전의 개수
				K %= arr[i]; // 나머지를 다시 K에 대입
			}
		}
		bw.write(res+"\n");
		bw.flush();
		bw.close();
	}

}
