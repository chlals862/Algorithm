package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bitmap {
	static class dot {
		int x,y;
		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int R,C;
	static int[][] map;
	static int[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<dot> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
		printData();
	}
	private static void printData() throws IOException {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				bw.write(visit[row][col]-1+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	private static void logic() {
		q = new LinkedList<dot>();
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 0) {
					visit[row][col] = 1;
					q.add(new dot(row,col));
				}
			}
		}
		bfs();
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			dot dot = q.poll();
			for(int dir=0;dir<4;dir++) {
				int nr = dot.x + dr[dir];
				int nc = dot.y + dc[dir];
				if(rangeCheck(nr,nc) && map[nr][nc] == 1 && visit[nr][nc] == 0) {
						visit[nr][nc] = visit[dot.x][dot.y]+1;
						q.add(new dot(nr, nc));
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
		visit = new int[R][C];
		for(int row=0;row<R;row++) {
			String[] str = br.readLine().split("");
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(str[col]);				
				map[row][col] = map[row][col] == 1 ? 0 : 1;
//				if(map[row][col] == 1) {
//					map[row][col] = 0;
//				} else {
//					map[row][col] = 1;
//				}
			}
		}
	}
}
