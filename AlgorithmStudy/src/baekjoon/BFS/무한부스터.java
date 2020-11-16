package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 무한부스터 {
	static int R, C;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = {0,1};
	static int[] dc = {1,0};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
		bw.flush();
		bw.close();
	}
	private static void logic() throws IOException {
		q.add(new int[] {0,0,0});
		visit[0][0] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				int cnt = currentRC[2];
				int booster = map[cr][cc];
				if(cr == R-1 && cc == C-1) {
					bw.write(cnt+"");
					return;
				}
				for(int dir=0;dir<2;dir++) {
					for(int j=1;j<=booster;j++) {
						int nr = cr + dr[dir]*j;
						int nc = cc + dc[dir]*j;
						if(rangeCheck(nr,nc)) {
							if(!visit[nr][nc]) {
								q.add(new int[] {nr,nc,cnt+1});
								visit[nr][nc] = true;
							}
						}
					}
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
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for (int row = 0; row < R; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < C; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
