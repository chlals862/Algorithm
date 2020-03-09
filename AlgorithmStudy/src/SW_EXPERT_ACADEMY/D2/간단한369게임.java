package SW_EXPERT_ACADEMY.D2;

import java.util.Scanner;

public class 간단한369게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();

		for (int i = 1; i <= A; i++) {
			if (A >= 10 && A <= 1000) {
				String num = String.valueOf(i);
				String count = "";
				boolean a = false;
				for (char mino : num.toCharArray()) {
					if (mino == '3' || mino == '6' || mino == '9') {
						a = true;
						count += "-";
					}
				}
				if (a) {
					System.out.print(count);
				} else {
					System.out.print(num);
				}
				System.out.print(" ");
			}
		}
	}
}
