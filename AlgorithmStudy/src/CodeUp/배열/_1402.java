package CodeUp.배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1402 {
	static int num;
	static int[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		num = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[num];
		
		for(int row=0;row<arr.length;row++) {
			arr[row] = Integer.parseInt(st.nextToken());
		}
		
		for(int row=0;row<arr.length-1;row++) {
			for(int col=row+1;col<arr.length;col++) {
				if(arr[row] < arr[col]) {
					int temp = arr[col];
					arr[col] = arr[row];
					arr[row] = temp;
				}
			}
		}
		for(int row=0;row<arr.length;row++) {
			bw.write(arr[row] + " ");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}

}
