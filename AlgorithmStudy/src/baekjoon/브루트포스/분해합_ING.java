package baekjoon.브루트포스;

import java.util.Scanner;

/*어떤 자연수 N이 있을 때,
그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 
예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 
물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 
반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.*/

//첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.
//입력 216 -> 출력 198 -> 198 + 1 + 9 + 8 -> 216
//입력 254 -> 출력 245 -> 245 + 2 + 4 + 5 -> 256
public class 분해합_ING {
	static int sum = 0;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		int input[] = new int[num];
		String s = String.valueOf(num); //256 입력시 256
		System.out.println("String.valueOf(num) = " + s);
		int n = s.length(); //256입력시 3
		//-------------------------미완성-------------------------
		System.out.println("s.length = " + n);
		//-------------------------미완성-------------------------
		for(int i=0;i<num;i++) {
			input[i] = num; 
		}//for
		//-------------------------미완성-------------------------	
		//245 - > 256 
		for(int i=0;i<n;i++) {
			int result = s.charAt(i) - '0';
			sum -= result;
			System.out.println("result = " + result);
		}
		System.out.println("sum = " + sum);
		//-------------------------미완성-------------------------
	}
}
