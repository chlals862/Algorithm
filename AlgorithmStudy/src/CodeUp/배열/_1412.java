package CodeUp.배열;

import java.util.Scanner;

public class _1412 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];
		String[] str = sc.nextLine().split("");
		
		for(int row=0;row<str.length;row++) {
			for(char col='a';col<='z';col++) {
				if(str[row].charAt(0)==col) {
					arr[(int)col-97]++;
				}
			}
		}
		
		for(int row=0;row<arr.length;row++) {
			System.out.println((char)(row+97)+":"+arr[row]);
		}
	}
}
