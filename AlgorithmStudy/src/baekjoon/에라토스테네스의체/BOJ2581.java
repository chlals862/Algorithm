package baekjoon.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2581 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[10001];
		prime[0] = prime[1] = true;
		
		for(int i=2;i<=prime.length-1;i++) {
			if(!prime[i]) {
				for(int j=2;i*j<=prime.length-1;j++) {
					prime[i*j] = true;
				}
			}
		}
		int cnt = 0;
		int sum = 0;
		int min = 10001;
		for(int i=M;i<=N;i++) {
			if(!prime[i]) {
				cnt++;
				sum += i;
				min = Math.min(min, i);
			}
		}
		if(cnt > 0) {
			bw.write(sum+"\n");
			bw.write(min+"\n");
		}else bw.write(-1+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}
}
