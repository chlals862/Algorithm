package baekjoon.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		boolean[] prime = new boolean[1001];
		
		prime[0] = prime[1] = true;
		
		for(int i=2;i<=prime.length-1;i++) {
			if(!prime[i]) {
				for(int j=2;i*j<=prime.length-1;j++) {
					prime[i*j] = true;
				}
			}
		}
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		st = new StringTokenizer(br.readLine());
		while(N --> 0) {
			int target = Integer.parseInt(st.nextToken());
			if(!prime[target]) {
				cnt++;
			}
		}
		bw.write(cnt+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
