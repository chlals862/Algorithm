package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 숫자빈도수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		for(int i=1;i<=N;i++) {
			String str = Integer.toString(i);
			for(int j=0;j<str.length();j++) {
				int res = str.charAt(j)-'0';
				//System.out.print(s+"");
				if(D == res) cnt++;
			}
		}
		bw.write(cnt+"");
		bw.flush();
		bw.close();
	}

}
