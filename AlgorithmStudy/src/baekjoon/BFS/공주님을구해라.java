package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 공주님을구해라 {
	static class knight {
		int r,c,item,time;
		public knight(int r, int c, int item, int time) {
			this.r = r;
			this.c = c;
			this.item = item;
			this.time = time;
		}
	}
	static int R,C,T;
	static int result;
	static int[][] map;
	static boolean[][][] visit;
	static boolean flag;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<knight> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
		printData();
	}
	private static void printData() throws IOException {
		if(flag) {
			bw.write(result + "\n");
		} else {
			bw.write("Fail");
		}
		bw.flush();
		bw.close();
	}
	private static void logic() {
		int time = T;
		q = new LinkedList<knight>();
		q.add(new knight(0, 0, 0, time));
		visit[0][0][0] = true;
		bfs();
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				knight knight = q.poll();
				if(map[knight.r][knight.c] == 2) knight.item = 1;
				if(knight.time == 0) continue;
				for(int dir=0;dir<4;dir++) {
					int nr = knight.r + dr[dir];
					int nc = knight.c + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(nr == R-1 && nc == C-1) {
							result = T-knight.time+1;
							flag = true;
							return;
						}
						if(visit[nr][nc][knight.item]) continue;
						if(knight.item == 1 && map[nr][nc] == 1) {
							q.add(new knight(nr, nc, knight.item, knight.time-1));
							visit[nr][nc][knight.item] = true;
						}
						if(map[nr][nc] == 0 || map[nr][nc] == 2) {
							q.add(new knight(nr, nc, knight.item, knight.time-1));
							visit[nr][nc][knight.item] = true;
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
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C][2];
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
