package baekjoon.배열;

import java.util.HashSet;
import java.util.Scanner;

public class 나머지 {
	static final int divide = 42;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> list1 = new HashSet<Integer>();
		int[] arr = new int[10];
		
		for(int i=0;i<10;i++) {
			arr[i] = sc.nextInt();
			
			int mok = arr[i]%divide;
			list1.add(mok);
		}
		System.out.println(list1.size());
		
	}
}
