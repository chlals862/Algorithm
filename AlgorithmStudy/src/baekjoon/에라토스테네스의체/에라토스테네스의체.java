package baekjoon.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 에라토스테네스의체 {
	static int N,K,count,answer;
	static int[] prime;
	static int[] num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		prime = new int[N+1];
		for(int row=2;row<=N;row++) {
			if(prime[row] == 0) { 
				prime[row] = 1;
				count++;
				if(count == K) {
					bw.write(row+"");
					break;
				}
				for(int col=2;col*row<=N;col++) {
					if(prime[row*col] == 0) {
						prime[row*col] = 1;
						count++;
					}
					if(count == K) {
						bw.write(row*col+"");
						break;
					}
				}
			}
		}
		bw.flush();
		bw.close();
	}
}
