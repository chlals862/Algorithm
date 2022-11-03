package baekjoon.시뮬레이션;

import java.util.Scanner;

public class BOJ수열의변화 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		String[] strArr = new String[N];
		String str = sc.next();
		
		strArr = str.split(",");
		for(int i=0;i<arr.length;i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		
		for(int i=0;i<K;i++) {
			for(int j=0;j<N-1;j++) {
				arr[j] = arr[j+1]-arr[j];
			}
		}
		
		for(int i=0;i<N-K;i++) {
			sb.append(arr[i]+",");
		}
		sb.delete(sb.length()-1, sb.length());
		System.out.println(sb);
	}
}
