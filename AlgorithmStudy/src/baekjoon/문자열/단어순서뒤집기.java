package baekjoon.문자열;

import java.util.Scanner;

public class 단어순서뒤집기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		
		for(int row=0;row<num;row++) {
			String str = sc.nextLine(); 
			String[] arr = str.split(" ");
			System.out.print("Case #" + (row+1)+": ");
			for(int col=arr.length-1;col>=0;col--) {
				System.out.print(arr[col]+" ");
			}
			
			System.out.println();
		}
		
	}
}
