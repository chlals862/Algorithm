package SW_EXPERT_ACADEMY.D1;

import java.util.Scanner;

public class N줄덧셈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int sum = 0;

		if (input <= 10000) {
			for (int i = 0; i <= input; i++) {
				sum += i;
			}
		}
		System.out.println(sum);

	}
}
