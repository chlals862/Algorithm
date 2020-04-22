package baekjoon.문자열처리;

import java.util.Scanner;

/*알파벳 소문자로만 이루어진 단어가 주어진다.
이때, 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.
팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다. 
level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다.
-------------------------------------------------------------
* 출력 
* 첫째 줄에 팰린드롬이면 1, 아니면 0을 출력한다.
*/
public class 펠린드롬인지확인하기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String inputStr = sc.nextLine();
		
		int length = inputStr.length();

			
			for(int i = 0; i<length; i++) {
				
				if(inputStr.charAt(i) != inputStr.charAt(length-i-1)) {
					System.out.println(0);
					return;
				}
			}
		System.out.println(1);
	}
}
