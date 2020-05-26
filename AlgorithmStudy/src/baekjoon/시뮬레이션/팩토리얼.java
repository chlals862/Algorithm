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
				 //num에 1을 준것은 0!이 1이기때문이고
				 /* input이 5일때
				  * for문은 5 4 3 2 1 돈다
				  * 5 x 1 = 5
				  * 4 x 5 = 20
				  * 3 x 20 = 60
				  * 2 x 60 = 120
				  * 1 x 120 = 120
				  * */
				 
				 
			}
			 System.out.println(num);
	}
}
