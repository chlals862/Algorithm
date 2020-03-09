package SW_EXPERT_ACADEMY.D1;

import java.util.Scanner;

public class 거꾸로출력하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		
		for(int j=i; j>=0; j--) {
			System.out.print(j+" ");
		}
	}
}
