package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 점수집계 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		//st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[5];
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<arr.length;j++) {
				arr[j] = Integer.parseInt(st.nextToken());	
			}
			Arrays.sort(arr);
			if(arr[arr.length-2] - arr[1] >= 4) {
				bw.write("KIN"+"\n");
			}else bw.write(arr[1]+arr[2]+arr[3]+"\n");
		}
		bw.flush();
		bw.close();
	}

}
