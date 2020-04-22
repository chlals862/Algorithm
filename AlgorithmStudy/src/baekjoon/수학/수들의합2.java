package baekjoon.수학;

/*N개의 수로 된 수열 A[1], A[2], …, A[N] 이 있다. 
이 수열의 i번째 수부터 j번째 수까지의 합 
A[i]+A[i+1]+…+A[j-1]+A[j]가 M이 되는 경우의 수를 구하는 프로그램을 작성하시오.*/
import java.util.Scanner;

public class 수들의합2 {
	//static int front;
	//static int last;
	static int sum;
	static int cnt = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int inputNum = sc.nextInt();
		int max = sc.nextInt();

		int[] arr = new int[inputNum];
		// 0123
//		front = 0;
//		last = arr.length;

		for (int i = 0; i < inputNum; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < inputNum; i++) {
			sum = 0;
			for (int j = i; j < inputNum; j++) {
				sum += arr[j];
				//System.out.println("sum =" + sum);
				if(sum == max) {
					cnt++;
					break;
				}
				
			}
		}
		System.out.println(cnt);

	}
}
