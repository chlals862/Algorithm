package SW_EXPERT_ACADEMY.D1;

import java.util.Scanner;

public class 스탬프찍기 {
	/*
	 * 입력한 숫자만큼 '#'찍기
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		for (int i = 1; i <= a; i++) {
			if (a <= 100) {
				System.out.print("#");
			} else {
				System.out.println("100 초과");
			}
		}
	}
}
