package baekjoon.수학;

import java.util.Scanner;

public class 최소최대값 {
	/*
	 * N개의 정수가 주어지고 이때, 최소값 최대값 구하기
	 * 모든 정수는 -1,000,000보다 크거나 같고, -> high
	 * 1,000,000보다 작거나 같은 정수이다. -> low
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		//입력한 숫자만큼 배열에 담기
		int[] num = new int[input];
		int high = -1000000;
		int low = 1000000;
		
		if(input >= 1 && input <= 1000000) {
			for(int i=0;i<num.length;i++) {
				num[i] = sc.nextInt();
				
				//math.max -> max,num[i]중 가장 큰수 반환 ->최대값
				//math.min -> min,num[i]중 가장 작은수 반환 ->최소값
				high = Math.max(high, num[i]);
				low = Math.min(low, num[i]);
				
				//System.out.println(num[i]);
			}//for
		}//if
		System.out.printf("%d %d\n",low,high);
	}
}
