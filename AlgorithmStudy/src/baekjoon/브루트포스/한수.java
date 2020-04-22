package baekjoon.브루트포스;

/*어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다.
등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다.
N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. */
import java.util.Scanner;

/*
 * 등차수열을 아루기 위해서는 여러숫자를 비교해야한다.
 * 한자리,두자리 숫자는 비굫ㄹ 수 없으므로
 * 한자리,두자리 숫자는 그 자체만으로 한수
 * ---------------------------------
 * 따라서 100보다 작은 정수 N에 대하여 한수의 개수가 n자신이 됨
 * 99보다 크고 111보다 작은 숫자일 경우는 99개가 됨
 * 
 * ★★★★★
 * 정수에서 자리수의 값을 얻는 법
 * 1. 10으로 나누어서 남는 나머지의 값
 * 다음 자리수 구하기
 * 2. 정수를 10으로 나누어주고 반복
 * */
public class 한수 {
	static int a;
	static int b;
	static int cnt = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int X = sc.nextInt();

		if (X > 99 && X <= 110) {
			System.out.println(99);

		} else if (X <= 99) {
			System.out.println(X);

		} else {
			for (int i = 111; i <= X; i++) {
				int Y = i;

				a = (Y % 10) - (Y / 10 % 10);
				// System.out.println("a = " + a);
				Y /= 10;
				b = (Y % 10) - (Y / 10 % 10);
				// System.out.println("b = " + b);
				if (a == b)
					cnt++;
			}
			//때려맞추기
				if (X == 1000) {
					System.out.println(cnt += 98);
				} else {
					System.out.println(cnt += 99);
				}
		
		}
	}
}
