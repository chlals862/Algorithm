package SW_EXPERT_ACADEMY.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 백만이하의모든소수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] prime = new boolean[1000001];
		
		prime[0] = prime[1] = true;
		
		for(int i=2;i<=prime.length-1;i++) {
			if(!prime[i]) {
				for(int j=2;i*j<=prime.length-1;j++) {
					prime[i*j] = true;
				}
			}
		}
		
		for(int i=2;i<=prime.length-1;i++) {
			if(!prime[i]) {
				bw.write(i+" ");
			}
		}
		br.close();
		bw.flush();
		bw.close();
		
	}
}
