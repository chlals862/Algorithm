package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 사분면고르기 {
	static int A,B;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		B = Integer.parseInt(st.nextToken());
		if(A > 0 && B > 0 ) bw.write(1+"");
		else if (A < 0 && B > 0) bw.write(2+"");
		else if (A < 0 && B < 0) bw.write(3+"");
		else if (A > 0 && B < 0) bw.write(4+"");
		bw.flush();
		bw.close();
	}
}
