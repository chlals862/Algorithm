package baekjoon.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		boolean[] prime = new boolean[1000001];
		
		prime[0] = prime[1] = true;
		//true -> 소수x
		//false -> 소수o
		
		for(int i = 2; i<= prime.length-1; i++) {
			if(!prime[i]) {
				for(int j = 2; i*j<= prime.length-1; j++) {
					prime[i*j] = true;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i=M;i<=N;i++) {
			if(!prime[i]) {
				bw.write(i+"\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
