package baekjoon.문자열;

import java.util.Scanner;

public class 크로아티아알파벳 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] arr = {"c=", "c-", "dz=", "dz-", "d-", "lj", "nj", "s=", "z="};
		String str = sc.nextLine();
		
		for(int row=0;row<arr.length;row++) {
			if(str.contains(arr[row])) {
				str = str.replace(arr[row], "o");
			}
		}
		System.out.println(str.length());
	}
}
