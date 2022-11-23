package SW_EXPERT_ACADEMY.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 테네스의특별한소수 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		boolean[] prime = new boolean[1000001];
		prime[0] = prime[1] = true;
		
		for(int i=2;i<=prime.length-1;i++) {
			if(!prime[i]) {
				for(int j=2;i*j<=prime.length-1;j++) {
					prime[i*j] = true;
				}
			}
		}
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			for(int i=A;i<=B;i++) {
				if(!prime[i]) {
					String str = String.valueOf(i);
					for(int j=0;j<str.length();j++) {
						if(str.charAt(j)-'0' == D) {
							cnt++;
							break;
						}
					}
					
				}
			}
			bw.write("#"+t+" "+cnt+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
