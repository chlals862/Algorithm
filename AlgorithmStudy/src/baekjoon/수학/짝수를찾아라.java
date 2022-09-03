package baekjoon.수학;

import java.util.ArrayList;
import java.util.Scanner;

public class 짝수를찾아라 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		while(N --> 0) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int sum = 0;
			int min = Integer.MAX_VALUE;
			
			for(int row=0;row<7;row++) {
				list.add(sc.nextInt());
				if(list.get(row) % 2 == 0) {
					sum += list.get(row);
					min = Math.min(list.get(row),min);
				}
			}
			System.out.println(sum + " " + min);
		}
	}
}
