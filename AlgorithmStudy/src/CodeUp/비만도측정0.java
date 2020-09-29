package CodeUp;

import java.util.Scanner;

public class 비만도측정0 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		
		if(input <= 10) {
			System.out.println("정상");
		}else if(input <= 20) {
			System.out.println("과체중");
		}else {
			System.out.println("비만");
		}
	}
}
