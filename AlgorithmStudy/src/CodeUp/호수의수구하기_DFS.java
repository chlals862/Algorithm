package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 호수의수구하기_DFS {
	static int R,C,num;
	static char[][] map;
	static boolean[][] visit;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
		printData();
	}
	private static void printData() throws IOException {
		bw.write(list.size()+"\n");
		bw.flush();
		bw.close();
	}
	private static void logic() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 'L' && !visit[row][col]) {
					dfs(row,col);
					list.add(num);
				}
			}
		}
	}
	private static void dfs(int row, int col) {
		visit[row][col] = true;
		int[] dr = {-1,0,1,0,-1,-1,1,1};
		int[] dc = {0,1,0,-1,-1,1,1,-1};
		for(int dir=0;dir<8;dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == 'L' && !visit[nr][nc]) {
					dfs(nr,nc);
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			String str = br.readLine().replace(" ", "");
			for(int col=0;col<C;col++) {
				map[row][col] = str.charAt(col);
			}
		}
	}
}
