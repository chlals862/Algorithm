package baekjoon.수학;

import java.util.Arrays;
import java.util.Scanner;

public class 주사위세개 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] num = new int[3];
		for(int row=0;row<num.length;row++) {
			num[row] = sc.nextInt();
		}
		if(num[0] != num[1] && num[0] != num[2] && num[1] != num[2]) {
			Arrays.sort(num);
			System.out.println(num[num.length-1] * 100);
		}else {
			if(num[0] == num[1] && num[0] == num[2]) {
				System.out.println(10000 + num[0] * 1000);
			} else {
				if(num[0] == num[1] || num[0] == num[2]) {
					System.out.println(1000 + num[0] * 100);
				}else {
					System.out.println(1000 + num[1] * 100);
				}
			}
		}
	}
}
