package baekjoon.문자열처리;

import java.util.Scanner;

/*알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 
주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.*/
public class 아스키코드 {

	public static void main(String[] args) {
		
		//입력
		Scanner sc = new Scanner(System.in);

		//로직 
		String input = sc.nextLine();
		//출력
		System.out.println((int)input.charAt(0));
	}
}
