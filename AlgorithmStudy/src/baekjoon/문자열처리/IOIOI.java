package baekjoon.문자열처리;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class IOIOI {
	static char[] ch;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		char[] ch = br.readLine().toCharArray();
		int result = 0;
		int cnt = 0;
		for(int row=1;row<b-1;row++) {
			if(ch[row-1] == 'I' && ch[row] == 'O' && ch[row+1] == 'I') {
				cnt++;
				if(cnt == a) {
					cnt--;
					result++;
				}
				row++;
			} else cnt = 0;
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
