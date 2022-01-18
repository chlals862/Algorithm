package baekjoon.구현;

import java.util.Scanner;

public class 전자레인지 {
	static int A,B,C,D,E;
	static int time;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		time = 0;
		A = sc.nextInt(); //현재 고기 온도
		B = sc.nextInt(); // 목표 온도 20도
		C = sc.nextInt(); // 얼어 있는 고기를 1도씩 데우는데 걸리는 시간
		D = sc.nextInt(); // 얼어 있는 고기를 해동하는데 걸리는 시간
		E = sc.nextInt(); // 얼어 있지 않은 고기를 1도씩 데우는데 걸리는 시간 ,,,,3초.
		//ex) -10 , 20 , 5, 10 , 3
		// -10 
		if(A < 0) { //얼어 있는 고기 일때
			time += -A*C;
			time += D;
			time += B*E;
		}else if (A > 0) {
			int cc = B-A;
			time += cc*E;
		}
		System.out.println(time);
	}
	
	
}
