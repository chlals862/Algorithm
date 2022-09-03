package baekjoon.구현;

import java.util.Scanner;

public class 카드역배치 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] card = new int[21];
		
		for(int row=1;row<card.length;row++) {
			card[row] = row;
		}
		int t = 10;
		while(t --> 0) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			
			while(start <= end) {
				int tmp = card[start];
				card[start] = card[end];
				card[end] = tmp;
				start++;
				end--;
			}
			
		}
			
		for(int row=1;row<card.length;row++) {
			System.out.print(card[row]+" ");
		}
		
	}
}
