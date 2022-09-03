package baekjoon.수학;

import java.util.Scanner;

public class 점수계산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int[] arr = new int[k];
		int cnt = 0;
		int result = 0;
		
		for(int i=0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
			if(arr[i] == 0) {
				cnt = 0;
			}else if(arr[i] == 1) {
				cnt += 1;
				result += cnt;
			}
		}
		System.out.println(result);
	}
}
