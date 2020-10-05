package CodeUp;

import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 이상한출석번호부르기2 {
	static int k;
	static int[] num;
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();
		num = new int[k+1];
		
		for(int row=1;row<=k;row++) {
			num[row] = sc.nextInt();
		}
		for(int row=k;row>=1;row--) {
			System.out.print(num[row]+ " ");
			}
	}
}
