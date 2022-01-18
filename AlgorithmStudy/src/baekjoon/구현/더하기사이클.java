package baekjoon.구현;

import java.util.Scanner;
//몫 +나머지 = 값 , 
//나머지+값의 나머지
public class 더하기사이클 {
	static int input;// 0~99 정수 , A가 10보다 작을떄 0A로 두자리수를 만듦
	static int A, B; // A = 몫, B = 나머지
	static int sum,nextNum;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = sc.nextInt(); 
		//26 -> 2 + 6 = 8 count 1 
		//68 -> 6 + 8 = 14 count 2
		//84 -> 8 + 4 = 12 count 3
		//42 -> 4 + 2 = 6 count 4
		//26
		//입력값 26일때
		//A = input/10; //몫
		//B = input%10; //나머지
		int nextNum = input;
		while(true) {
			A = nextNum/10; //몫                     2
			B = nextNum%10; //나머지              6
			sum = A+B;    //            8
			nextNum = B * 10 + sum % 10;  //다음 값은, tostring 할 필요없이 , 나머지의 10을 곱한값 + sum을 10으로 나눈 나머지 값과 같다.
//			System.out.println("A = " + A);
//			System.out.println("B = " + B);
//			System.out.println("SUM = " + sum);
//			System.out.println("nextNum = " + nextNum);
			count++;
			if(nextNum == input) break;
			//input = nextNum;
		}
		
		System.out.println(count);
	}

}
