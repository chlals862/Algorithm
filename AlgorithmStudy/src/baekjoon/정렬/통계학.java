package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 통계학 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int Total = 0;
		int[] Result = new int[4];	//	1.산술평균, 2.중앙값, 3.최빈값, 4.범위
		int[] Int_Arrays = new int[N];	//	수의 개수
		int[] Much_Number = new int[8001];	//	최빈값을 계산하기 위한 배열
		// 음수범위의 배열은 없으므로 -4000 ~ 4000 을 0 ~ 8000으로 바꿔서 계산.
        
		for(int i = 0; i < N; i++) {
			Int_Arrays[i] = sc.nextInt();
			Total += Int_Arrays[i];	//	입력과 동시에 수들의 총 합을 계산.
			Much_Number[Int_Arrays[i] + 4000]++;	//	동시에 최빈값도 계산.
		}
		
		int min = 0;
		
		for(int i = 0; i < Much_Number.length; i++) {
			if(min < Much_Number[i]) {
				min = Much_Number[i];	//	최빈값을 계산한다.
			}
		}
		
		int[] two_min = new int[2];	//	가장 많이 나타나는 값이 여러 개일 경우를 위한 배열
		int j = 0;
		
		for(int i = 0; i < Much_Number.length; i++) {
			if(two_min[0] != 0 && two_min[1] != 0)
				break;
			
			if(min == Much_Number[i]) {
				two_min[j] = i;
				j++;
			}
		}	//	최빈값중 두 번째로 작은 값을 넣기위함.
		
		if(two_min[1] == 0)
			two_min[1] = two_min[0];
		
		Arrays.sort(Int_Arrays);	//	정렬
		
		Result[0] = (int) Math.round((double)Total / N);	//	산술평균
		Result[1] = Int_Arrays[N/2];	//	중앙값
		Result[2] = two_min[1] - 4000;	//	최빈값
		Result[3] = Int_Arrays[N-1] - Int_Arrays[0];	//	범위
		
		System.out.println(Result[0]);
		System.out.println(Result[1]);
		System.out.println(Result[2]);
		System.out.println(Result[3]);
	}
	
}
