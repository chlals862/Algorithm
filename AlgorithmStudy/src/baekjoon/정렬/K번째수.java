package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class K번째수 {
	static ArrayList<Integer> arr;
	static int N,K;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		inputData();
	}

	private static void inputData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<Integer>();
		int[] temp = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int row=0;row<N;row++) {
			//arr.add(Integer.parseInt(st.nextToken()));
			temp[row] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(temp);

		for(int row=0;row<temp.length;row++) {
//			if(arr.indexOf(row) == K) {
//				bw.write(row-1+"");
//			}
			if(temp[row] == K) {
				bw.write(row+1+"");
			}
		}
		bw.flush();
		bw.close();
		
	}
}
