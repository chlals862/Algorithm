package baekjoon.정렬;

import java.util.Arrays;
import java.util.Scanner;

/*
	 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
	 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 
	 * 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 
	 * 이 수는 절댓값이 1,000보다 작거나 같은 정수이다.
	 * 수는 중복되지 않는다.
	 * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
	 * */
public class 수정렬하기 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
//		Collections.sort(list); -> merge Sort기반
//		Arrays.sort(a); -> quick Sort기반
		
		int N = sc.nextInt();
		int num[] = new int[N];
		
		//입력
		if(N >= 1 && N <= 1000) {
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
	}
		
		//로직
		Arrays.sort(num);
		
		//출력
		for (int i = 0; i < N; i++) {
			System.out.println(num[i]);
		}
	}
}
