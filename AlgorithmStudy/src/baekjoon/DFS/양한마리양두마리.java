package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 양한마리양두마리 {
	static int T,R,C;
	static int count;
	static char[][] map;
	static boolean[][] visit;
	static ArrayList<Integer> list;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visit = new boolean[R][C];
			list = new ArrayList<Integer>();
			for(int row=0;row<R;row++) {
				String sLine = br.readLine();
				for(int col=0;col<C;col++) {
					map[row][col] = sLine.charAt(col);
				}
			}
			logic();
		}//case
		bw.flush();
		bw.close();
	}
	private static void logic() throws IOException {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == '#' && !visit[row][col]) {
					dfs(row,col);
					list.add(count);
				}
			}
		}
		bw.write(list.size()+"\n");
	}
	private static void dfs(int row, int col) {
		count++;
		visit[row][col] = true;
		for(int dir=0;dir<4;dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == '#' && !visit[nr][nc]) {
					dfs(nr,nc);
				}
			}
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
}
