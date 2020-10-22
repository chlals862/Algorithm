package 프로그래머스.스킬체크;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 일_1 {
	static int R,C;
	static char[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				map[row][col] = '*';
			}
		}
		printMap();
		bw.flush();
		bw.close();
	}
	private static void printMap() throws IOException {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				bw.write(map[row][col]+"");
			}
			bw.write("\n");
		}
	}
}
