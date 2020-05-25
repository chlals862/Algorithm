package baekjoon.시뮬레이션;

import java.util.Scanner;

public class 팩토리얼 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int num = 1;
			//i는 n승, 
			//input이 4일때
			//4*3*2*1
			
			for(int i=input; i>0; i--) {
				/* input * num; */
				//i는 4 3 2 1  ....
				//input은 4
				 num = i*num;	
			}
		System.out.println(num);
	}
}
