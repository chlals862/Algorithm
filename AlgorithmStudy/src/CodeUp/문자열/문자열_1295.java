package CodeUp.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 문자열_1295 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		String result = "";
		for(int row=0;row<str.length();row++) {
			int tmp = (int)str.charAt(row);
			if(65 <= tmp && tmp <= 90) result += (char)(tmp+32);
			else if(97 <= tmp && tmp <= 122) result += (char)(tmp-32);
			else result+=(char)tmp;
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
}
