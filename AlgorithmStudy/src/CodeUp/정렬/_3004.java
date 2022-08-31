package CodeUp.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _3004 {
	static int N;
	static int[] arr,num,base;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		base = new int[N];
		arr = new int[N];
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int row=0;row<arr.length;row++) {
			arr[row] = Integer.parseInt(st.nextToken());
			base[row] = arr[row];
		}
		
		Arrays.sort(arr);
		
		int inputNum = 0;
		for(int row=0;row<arr.length;row++) {
			num[row] = inputNum++;
		}
		
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(base[row] == arr[col]) {
					num[row] = col;
				}
			}
		}
		
		for(int row=0;row<num.length;row++) bw.write(num[row]+" ");
		bw.flush();
		bw.close();
		br.close();
	}
}
