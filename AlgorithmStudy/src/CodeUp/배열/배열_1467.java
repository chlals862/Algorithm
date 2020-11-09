package CodeUp.배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 배열_1467 {
	static int R, C;
	static int[][] map;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		int num = 1;
		for (int col = C-1; col >=0; col--) {
			for (int row = 0; row <R; row++) {
				map[row][col] = num++;
			}
		}
		printMap();
	}
	private static void printMap() throws IOException {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				bw.write(map[row][col] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
