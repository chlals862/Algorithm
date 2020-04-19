package baekjoon.구현;

import java.util.Scanner;

public class TGN {
	static int r,e,c;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int inputNum = sc.nextInt();
		int[] num = new int[inputNum];
		
		
		System.out.println();
		for(int i=0;i<inputNum;i++) {
			
			int r = sc.nextInt();
			int e = sc.nextInt();
			int c = sc.nextInt();
			System.out.println("r = " + r);
			System.out.println("e = " + e);
			System.out.println("c = " + c);
			/*
			 * if(r+e>c) { System.out.println("advertise"); }else if(r+e==c) {
			 * System.out.println("does not matter"); }else if(r+e<c) {
			 * System.out.println("do not advertise"); }
			 */
		}
		
		
	}
}
