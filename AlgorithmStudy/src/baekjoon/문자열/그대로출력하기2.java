package baekjoon.문자열;

import java.util.Scanner;

public class 그대로출력하기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			System.out.println(str);
		}
		sc.close();
	}

}
