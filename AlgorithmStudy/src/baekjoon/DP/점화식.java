package baekjoon.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*
t(0)=1
t(n)=t(0)*t(n-1)+t(1)*t(n-2)+...+t(n-1)*t(0)

*/
public class 점화식 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long[] res = new long[N+1];
		res[0] = 1;
		for(int i=1;i<=N;i++) {
			for(int j=0;j<i;j++) {
				res[i] += (res[j]*res[i-1-j]);
			}
		}
		bw.write((long) res[N]+"");
		bw.flush();
		bw.close();
	}

}
