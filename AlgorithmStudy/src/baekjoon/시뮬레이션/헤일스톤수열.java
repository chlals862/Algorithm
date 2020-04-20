package baekjoon.시뮬레이션;

/*
 * step1. n이 짝수 -> 2로 나눔
 * step2. n이 홀수 -> 3을 곱함 +1
 * 
 * n이 1이면 종료
 * output -> 가장 큰 값 출력
 * */
import java.util.Scanner;

public class 헤일스톤수열 {
	static int max = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int inputNum = sc.nextInt();

		for (int i = 0; i < inputNum; i++) {
			int a = sc.nextInt();
			int max = 0;
			max = a;
			//a가 1이 아닐때  계속 반복
			while(a != 1) {
				//가장 큰 값 구하기
				if(max <= a) {
					//System.out.println("max"+max);
					//System.out.println("a"+a);
					max =a;
				}
				
				if(a % 2 == 0 ) {
					a = a/2; //나누기가 '/'지 왜 '%'야.................
				}
				else if(a % 2 != 0 && a != 1) {
					a = a*3+1;
				}
				
			}
			System.out.println(max);
		}
		
	}
}
			/*while ( == 1) {
				if (num[i] % 2 == 0) {
					 max = num[i % 2];
					System.out.println("짝수");
				} else if (num[i] % 3 == 0) {
					 max = num[i * 3] + 1;
					System.out.println("홀수");
				}
			}*/
			//System.out.println(Math.max(num[i], max));


