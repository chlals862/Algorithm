package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2711 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			ArrayList<Character> list = new ArrayList<Character>();

			for(int row=0;row<str.length();row++) {
				list.add((char) str.codePointAt(row));
			}
			list.remove(target-1);
			
			for(Character result : list) {
				bw.write(result+"");
			}
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
