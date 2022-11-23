package baekjoon.에라토스테네스의체;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class BOJ15965 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[500001];
		
		prime[0] = prime[1] = true;
		
		for(int i=2;i<=prime.length-1;i++) {
			if(!prime[i]) {
				for(int j=2;i*j<=prime.length-1;j++) {
					prime[i*j] = true;
				}
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=2;i<=prime.length-1;i++) {
			if(!prime[i]) {
				list.add(i);
			}
		}
		bw.write(list.get(K-1)+"\n");
		br.close();
		bw.flush();
		bw.close();
	}
}
