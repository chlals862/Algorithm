package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 지뢰찾기_4108 {
	static int R,C;
	static char[][] input;
	static String[][] result;
	static int[][] map;
	static int[] dr = {-1,0,1,0,-1,-1,1,1};
	static int[] dc = {0,1,0,-1,-1,1,1,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			input = new char[R][C];
			result = new String[R][C];
			map = new int[R][C];
			for(int row=0;row<R;row++) {
				String str = br.readLine();
				for(int col=0;col<C;col++) {
					input[row][col] = str.charAt(col);
					if(input[row][col] == '*') result[row][col] = "*";
				}
			}
			logic();
			change();
			printMap();
			if(R == 0 && C == 0) break;
		}
	bw.flush();
	bw.close();
	}
	private static void change() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(result[row][col] == null) {
					result[row][col] = Integer.toString(map[row][col]);
				}
			}
		}
	}
	private static void logic() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				for(int dir=0;dir<8;dir++) {
					int nr = row + dr[dir];
					int nc = col + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(result[nr][nc] == "*") map[row][col] += 1;
					}
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
	private static void printMap() throws IOException {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				bw.write(result[row][col]+"");
			}
			bw.write("\n");
		}
	}
}
