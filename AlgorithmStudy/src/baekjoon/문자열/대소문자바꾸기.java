package baekjoon.문자열;

import java.util.Scanner;

public class 대소문자바꾸기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		char[] arr = new char[str.length()];
		
		for(int row=0;row<arr.length;row++) {
			arr[row] = str.charAt(row);
		}
		
		for(int row=0;row<arr.length;row++) {
			if(arr[row] >= 65 && arr[row] <= 90) { //대문자 A~Z -> 65 ~ 90
				arr[row] = (char)(arr[row]+32);
			}else if(arr[row] >= 97 && arr[row] <= 122) { //소문자  a~z -> 97 ~ 122
				arr[row] = (char)(arr[row]-32);
			}
		}
		System.out.print(arr);
	}
}
