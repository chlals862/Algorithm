package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
 * 수 N개가 주어졌을때 i~j번째 수까지의 합 구하기
 * [input]
 * 1번째 줄 = 수의 개수 N과 합을 구해야 하는 횟수 M
 * 2번째 줄 = N개의 수가 주어짐
 * 3번째 줄 = M개의 줄에는 합을 구해야 하는 구간 i,j가 주어짐
 * 
 * 1 <= N <= 100000
 * 1 <= M <= 100000
 * 이므로 이중포문X[시간초과]
 * 
 * ex)
    5 3
 	5 4 3 2 1
 	1 3
 	2 4
 	5 5
 * [output]
 * 12
 * 9
 * 3
 * */
public class 구간합구하기4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		/* 누적합을 한번에 미리 구하고 i~j번째 구간을 계산
		 * 누적합은 현재 인덱스의 합 = 현재 인덱스-1의 누적 합  + 현재 입력할 값
		 * ex) 5 4 3 2 1 의 누적합 -> 5 9 12 14 15
		 *  2번 인덱스 4[합9] ->  1번 인덱스의 누적합 + 현재 입력할 값[4] -> 9
		 * */
		//누적합 구하기
		for(int i=1;i<=N;i++) {
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		//System.out.println(arr[i]);  
			//누적합 5 9 12 14 15
		}
		//구간 i 부터 j까지의 합구하기
		//i가 3, j가 5일때 -> 5 4 3 2 1 ->구간의 누적합은  3 + 2 + 1 -> 6
		//arr[j] - arr[i-1]라는 식으로 대입을 해보면 -> arr[5]의 누적합은 15 - arr[3-1]은 9이므로 결과 15-9 = 6;
		for(int i=1;i<=M;i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			bw.write(arr[B]-arr[A-1]+"\n");
		}
		bw.flush();
		bw.close();
		
	}
}
