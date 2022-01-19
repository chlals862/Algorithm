package baekjoon.문자열처리;

import java.util.Scanner;

public class 더하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		String[] arr = str.split(",");
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			sum += Integer.parseInt(arr[i]);
		}
		System.out.println(sum);

	}

}
