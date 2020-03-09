package SW_EXPERT_ACADEMY.D1;

import java.util.Scanner;

public class 최대수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		for(int i=1;i<=input;i++) {
			int max = 0; //최대값
			for(int j=0;j<10;j++) {
				int num = sc.nextInt();
				
				if(max < num)
					max = num;
			}
			System.out.println("#" + i + " "+ max);
		}
		
	}
}
