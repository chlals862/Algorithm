package SW_EXPERT_ACADEMY.D1;

import java.util.Scanner;

public class 큰놈작은놈같은놈 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();

		if (num >= 0 && num <= 10000) {
			for (int i = 1; i <= num; i++) {
				String str;
				int input1 = sc.nextInt();
				int input2 = sc.nextInt();

				if (input1 == input2) {
					str = "=";
				} else if (input1 > input2) {
					str = ">";
				} else {
					str = "<";
				}
				System.out.println("#" + i + " " + str);
			}
		}
	}
}