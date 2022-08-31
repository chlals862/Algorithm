package CodeUp.문자열;

import java.util.Scanner;

public class _1419 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		char[] arr = new char[str.length()];
		int cnt = 0;
		for(int row=0;row<arr.length;row++) {
			arr[row] = str.charAt(row);
		}
		
		
		for(int row=0;row<arr.length;row++) {
			if(arr[row] == 'l') {
				if(arr[row+1] == 'o') {
					if(arr[row+2] == 'v') {
						if(arr[row+3] == 'e') {
							cnt++;
						}
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
