package baekjoon.구현;

import java.util.Scanner;

public class 피시방알바 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int result = 0;
		boolean[] flag = new boolean[101];
		
		for(int row=0;row<k;row++) {
			int i = sc.nextInt();
			
			if(flag[i]) {
				result++;
			} else {
				flag[i] = true;
			}
		}
		System.out.println(result);
	}
}
