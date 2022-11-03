package baekjoon.문자열;

import java.util.Scanner;

public class BOJ1259 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			boolean flag = false;
			String str = sc.next();
			if(str.equals("0")) break;
			
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i) != str.charAt(str.length()-1-i)) {
					flag = true;
					break;
				}
			}
			if(flag) {
				System.out.println("no");
			}else System.out.println("yes");
			
		}
	}
}
