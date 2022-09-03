package baekjoon.수학;

import java.util.Scanner;

public class 킹_퀸_룩_비숍_나이트_폰 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] base = {1,1,2,2,2,8};
		
		int[] change = new int[6];
		for(int row=0;row<change.length;row++) {
			change[row] = sc.nextInt();
			System.out.print(base[row] - change[row] + " ");
		}
	}
}
