package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
//절사 평균 (7,2) -> 양쪽 끝에서 두개 씩 제외 후 평균
//보정 평균 (7,2) -> 양쪽 끝에서 각각 두개를 남은 정수 중 가장 가까운 것으로 교체후 평균
public class 절사평균 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N,K; //N -> N개의 점수      K -> 양쪽에서 제외하는 개수
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		//br.readLine();
		double[] arr = new double[N];
		//System.out.println("N = " + N);
		for(int i=0;i<arr.length;i++) {
			arr[i] = Double.parseDouble(br.readLine());
		}
		Arrays.sort(arr);
		
		//절사평균 -> 양쪽 끝에서 K개 만큼 제외하고 평균 . 소수점이하 셋째 자리에서 반올림
		double sum = 0;
		double averageA = 0;
		for(int i=K;i<arr.length-K;i++) {
			sum += arr[i];
		}
		//System.out.println(sum);
		averageA = sum / (arr.length-(K*2));
		bw.write(String.format("%.2f", averageA)+"\n");
		//보정 평균 -> 양쪽 끝에서 K개를 남은 정수 중 가장 가까운 것으로 교체후 평균
		sum = 0;
		double averageB = 0;
		for(int i=0;i<K;i++) arr[i] = arr[K];
		for(int i=arr.length-1;i>=arr.length-K;i--) arr[i] = arr[arr.length-K-1];
		for(int i=0;i<arr.length;i++) sum += arr[i];
		averageB = sum / arr.length;
		bw.write(String.format("%.2f", averageB));
		
		bw.flush();
		bw.close();
	}

}
