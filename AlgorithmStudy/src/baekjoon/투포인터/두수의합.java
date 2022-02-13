package baekjoon.투포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합 {
	static int[] arr;
	static int result;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		for(int row=0;row<n;row++) arr[row] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int goal = Integer.parseInt(st.nextToken());
		int sum = 0;
		Arrays.sort(arr);
		//for(int row=0;row<n;row++) System.out.println(arr[row]+ " ");
		int start = 0; int end = n-1;
		while(start < end) {
			sum = arr[start] + arr[end];
			if(sum == goal) {
				result++;
			} 
			if(sum <= goal) start++;
			else end--;
			
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
