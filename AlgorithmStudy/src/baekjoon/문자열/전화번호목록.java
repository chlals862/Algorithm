package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
//startsWith 메소드 -> 대상 문자열이 특정 문자 또는 문자열로 시작하는지 체크하는 함수 ★★★★★
//12345.startsWith("123") -> true반환
public class 전화번호목록 {
	static int T,N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			N = Integer.parseInt(br.readLine());
			String[] pNum = new String[N];
			for(int row=0;row<N;row++) pNum[row] = br.readLine();
			Arrays.sort(pNum);
			boolean flag = false;
			for(int row=0;row<N-1;row++) {
				if(pNum[row+1].startsWith(pNum[row])) {
					flag = true;
					break;
				}else flag = false;
			}
			
			if(flag) bw.write("NO\n");
			else bw.write("YES\n");
		}
		bw.flush();
	}

}
