package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class paintbucket {
	static int R,C,startR,startC,paint;
	static int[][] map;
	static boolean[][] visit;
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
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			String[] str = br.readLine().split("");
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(str[col]);
			}
		}
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken());
		startC = Integer.parseInt(st.nextToken());
		paint = Integer.parseInt(st.nextToken());
		
		dfs(startR,startC);
		
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(visit[row][col]) {
					map[row][col] = paint;
				}
			}
		}
		printMap();
		bw.flush();
		bw.close();
	}
	private static void dfs(int row, int col) {
		visit[row][col] = true;
		int color = map[row][col];
		for(int dir=0;dir<4;dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == color && !visit[nr][nc]) {
					dfs(nr,nc);
				}
			}
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C ) return true;
			return false;
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
