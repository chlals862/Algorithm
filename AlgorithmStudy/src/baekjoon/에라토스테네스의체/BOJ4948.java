package baekjoon.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ4948 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] prime = new boolean[123456*2+1];
		
		prime[0] = prime[1] = true;
		
		for(int i=2;i<=prime.length-1;i++) {
			if(!prime[i]) {
				for(int j=2;i*j<=prime.length-1;j++) {
					prime[i*j] = true;
				}
			}
		}
		
		while(true) {
			int n = Integer.parseInt(br.readLine());
			int cnt = 0;
			if(n == 0) break;
			
			for(int i=n+1; i<=n*2;i++) {
				if(!prime[i]) {
					cnt++;
				}
			}
			bw.write(cnt+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
