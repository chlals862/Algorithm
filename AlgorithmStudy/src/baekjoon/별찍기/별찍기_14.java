package baekjoon.별찍기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 별찍기_14 {
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				bw.write("*");
			}
			bw.write("\n");
		}
	bw.flush();
	bw.close();
	}
}
