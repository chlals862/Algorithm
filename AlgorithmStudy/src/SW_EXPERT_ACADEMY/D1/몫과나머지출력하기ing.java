package SW_EXPERT_ACADEMY.D1;

import java.util.Scanner;

public class 몫과나머지출력하기ing {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		
		int a = 0;
		int b = 0;
		
		for(int i=1;i<count;i++) {
			int mok = a/b;
			int na = a%b;
			System.out.println("#" + i + " " + mok + " " + na);
		}
	}
}
