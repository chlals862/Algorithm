package CodeUp.배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1095 {
	static int[] arr;
	static int num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		num = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[num];
		
		for(int row=0;row<arr.length;row++) arr[row] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		bw.write(arr[0]+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
