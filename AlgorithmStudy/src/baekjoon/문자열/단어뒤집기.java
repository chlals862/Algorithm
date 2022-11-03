package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 단어뒤집기 {
	static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		while(t --> 0) {
			st = new StringTokenizer(br.readLine());
			while(st.hasMoreElements()) {
				StringBuilder sb2 = new StringBuilder(st.nextToken());
				sb.append(sb2.reverse()+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
