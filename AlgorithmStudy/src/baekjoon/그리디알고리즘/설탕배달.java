package baekjoon.그리디알고리즘;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 설탕배달 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int res = 0;
		
		while(true) {
			if(N % 5 == 0) {
				bw.write(N/5 +res+"\n");
				break;
			}
				else if(N < 0) {
					bw.write(-1+"\n"); 
					break;
				}
			N = N-3;
			res++;
	}
		bw.flush();	
		bw.close();
	}
}
