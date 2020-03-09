package SW_EXPERT_ACADEMY.D1;

import java.util.Scanner;

public class 신문헤드라인 {
	/*
	 * 입력된 문자열을 대문자로
	 * */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s  = sc.nextLine();
		String m = s.toUpperCase();
		
		System.out.println(m);
		
	}
}
