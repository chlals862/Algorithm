package baekjoon.문자열;

import java.util.Scanner;

public class 그룹단어체크 {
	static boolean[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		
		for(int row=0;row<num;row++) {
			String str = sc.next();
			check = new boolean[26];
			boolean temp = true;
			
			for(int col=0;col<str.length();col++) {
				int idx = str.charAt(col)-'a';
				if(check[idx]) {	
				if(str.charAt(col) != str.charAt(col-1)) {
						temp = false;
						break;
				}
					}else check[idx] = true;
			}
			if(temp) count++;
		}
		System.out.println(count);
	}
}
