package 채찍질;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class 최소최대 {

	static int N,MAX,MIN;
	static int[] num;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		num = new int[N];
		for(int row=0;row<num.length;row++) {
			num[row] = sc.nextInt();
		}
		Arrays.sort(num);

		for(int i=0;i<num.length;i++) {
			MAX = num[0];
			MIN = num[num.length-1];
		}
		System.out.println(MAX);
		System.out.println(MIN);
	}
}
