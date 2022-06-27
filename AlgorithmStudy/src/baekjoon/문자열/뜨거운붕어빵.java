package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 뜨거운붕어빵 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				bw.write(str.charAt(C-col-1));
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
