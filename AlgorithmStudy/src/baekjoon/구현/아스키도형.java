package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 아스키도형 {
	static int R,C;
	static char[][] map;
	static double sum = 0.0;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int row=0;row<R;row++) map[row] = br.readLine().toCharArray();
		int cnt = 0;
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == '/' || map[row][col] == '\\') {
					sum += 0.5;
					cnt++;
				}
				if(cnt % 2 == 1 && map[row][col] == '.') sum++;
			}
		}
		bw.write((int)sum+"");
		bw.flush();
		bw.close();
	}

}
