package CodeUp.단순반복문;

import java.util.Scanner;

public class _1090 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Long start = sc.nextLong(); //2
		Long mul = sc.nextLong(); //3
		Long k = sc.nextLong(); // 7
		
		Long result = start*mul;
		
		for(int i=1;i<k-1;i++) {
			result *= mul;
		}
		System.out.println(result);
	}
}
