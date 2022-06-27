package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수정렬하기5 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int num = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[num];
		for(int row=0;row<arr.length;row++) arr[row] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		for(int row=0;row<arr.length;row++) sb.append(arr[row]).append("\n");
	
		System.out.print(sb);
		br.close();
	}
}
