package CodeUp.중첩반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1084 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<r;i++) {
			for(int j=0;j<g;j++) {
				for(int k=0;k<b;k++) {
					bw.write(i+" "+j+" "+k+"\n");
				}
			}
		}
		bw.write(r*g*b+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
