package SW_EXPERT_ACADEMY.D1;

import java.util.Scanner;
	/*
	 * 입력
	 * A B C D E F ...
	 * 출력
	 * 1 2 3 4 5 6 ...
	 * */
public class 알파벳을순자로변환 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		for(int i=0;i<s.length();i++) {
			System.out.print((s.charAt(i) - 'A' +1) + " ");
		}
	}
}
