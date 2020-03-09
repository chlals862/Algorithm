package SW_EXPERT_ACADEMY.D1;

import java.util.Scanner;

public class 평균값구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);	
		int num = sc.nextInt();
		
		for(int i=1;i<=num;i++) {
			float sum = 0;
			
			for(int j= 0;j<10;j++) {
				int number = sc.nextInt();
				sum += number;
			}
			
			System.out.println("#" + i + " " + Math.round(sum/10));
		}
	}
}
