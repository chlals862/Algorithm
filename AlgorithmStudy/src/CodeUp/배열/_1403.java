package CodeUp.배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1403 {
	static int k;
	static int[] arr;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		arr = new int[k];
		
		for(int row=0;row<arr.length;row++) {
			arr[row] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int row=0;row<arr.length;row++) {
				bw.write(arr[row]+"\n");
		}
		for(int row=0;row<arr.length;row++) {
			bw.write(arr[row]+"\n");
	}
		bw.flush();
		bw.close();
		br.close();
	}
}
