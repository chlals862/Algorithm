package SW_EXPERT_ACADEMY.D3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _24시간 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for(int i=1;i<=T;i++) {
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			sum = A+B;
			int res = sum-24;
			if(sum > 24) {
				bw.write("#"+i+" "+res+"\n");
			}else if(sum < 24) {
				bw.write("#"+i+" "+sum+"\n");
			}else bw.write("#"+i+" 0\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
