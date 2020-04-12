package baekjoon.문자열처리;
//알파벳으로만 이루어진 단어를 입력받아, 그 길이를 출력하는 프로그램을 작성하시오.

import java.util.Scanner;

//ex pulljima -> 8
public class 단어길이재기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		/*
		 * for(int i=0;i<s.length();i++) {
		 * 
		 * }
		 */
		System.out.println(s.length());
	}
}
