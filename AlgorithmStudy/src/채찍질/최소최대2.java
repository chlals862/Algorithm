package 채찍질;

import java.util.Scanner;

public class 최소최대2 {
	static int N,MAX,MIN;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		num = new int[N];
		for(int row=0;row<num.length-1;row++) {
			num[row] = sc.nextInt();
			
			if(num[row]>num[row+1]) {
				MAX = num[row];
			}else {
				MIN = num[row+1];
			}
		}
		System.out.println(MAX);
		System.out.println(MIN);
	}
}
