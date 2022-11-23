package baekjoon.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ11170 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for(int i=N;i<=M;i++) {
				int sub = i;
				
				if(sub == 0) {
					cnt++;
				}
				
				while(sub > 0) {
					if(sub % 10 == 0) {
						cnt++;
					}
					sub/=10;
				}
			}
			bw.write(cnt+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
