package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 문자열반복 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());//테스트 케이스
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char[] ch = st.nextToken().toCharArray();
			
			for(int j=0;j<ch.length;j++) { //문자열 길이만큼 반복 및 한글자씩 세분화
				for(int k=0;k<N;k++) {
					bw.write(ch[j]+""); //반복 출력 횟수 만큼 반복
				}
				
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
