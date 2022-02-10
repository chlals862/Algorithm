package baekjoon.수학;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 막대기 {
	static int X,result;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		int stick = 64;
		while(X > 0) {
			if(stick>X) stick/=2;
			else {
				result+=1;
				X-=stick;
			}
		}
		bw.write(result+"");
		bw.flush();
		bw.close();
	}

}
