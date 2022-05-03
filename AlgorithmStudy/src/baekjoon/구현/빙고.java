package baekjoon.구현;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 빙고 {
	static int[][] bingo;
	static int count;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		bingo = new int[5][5];
		count = 0;
		
		for(int row=0;row<5;row++) {
			
			for(int col=0;col<5;col++) {
				bingo[row][col] = sc.nextInt();
			}
		}
		
		for(int i=1;i<=25;i++) {
			int num = sc.nextInt();
			for(int row=0;row<5;row++) {
				for(int col=0;col<5;col++) {
					if(bingo[row][col] == num) bingo[row][col] = 0;
				}
			}
			
			rowCheck();
			colCheck();
			leftCheck();
			rightCheck();
			
			if(count >= 3) {
				System.out.println(i);
				break;
			}
			count = 0;
		}
	}
	private static void rightCheck() {
		int zeroCnt = 0;
		for(int row=0;row<5;row++) {
			if(bingo[row][4-row] == 0) zeroCnt++;
		}
		if(zeroCnt == 5) count++;
		
	}
	private static void leftCheck() {
		int zeroCnt = 0;
		for(int row=0;row<5;row++) {
			if(bingo[row][row] == 0 ) zeroCnt++;
		}
		if(zeroCnt == 5) count++;
		
	}
	private static void colCheck() {
		for(int row=0;row<5;row++) {
			int zeroCnt = 0;
			for(int col=0;col<5;col++) {
				if(bingo[row][col] == 0) zeroCnt++;
			}
			if(zeroCnt == 5) count++;
		}
		
	}
	private static void rowCheck() {
		for(int row=0;row<5;row++) {
			int zeroCnt = 0;
			for(int col=0;col<5;col++) {
				if(bingo[row][col] == 0) zeroCnt++;
			}
			if(zeroCnt == 5) count++;
		}
		
	}

}
