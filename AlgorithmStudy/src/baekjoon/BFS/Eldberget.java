package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Eldberget {
	static int R,C,K,res;
	static char[][] map;
	static boolean[][][] visit;
	static boolean flag;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<Point> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C][201];
		
		for(int i=0;i<R;i++) map[i] = br.readLine().toCharArray();
		
		bfs();
		
		if(flag) bw.write(res+"\n");
		else bw.write("nej\n");
		bw.flush();
	}
	private static void bfs() {
		q.add(new Point(0, 0, 0, 0));
		visit[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Point current = q.poll();
			for(int dir=0;dir<4;dir++) {
				int nr = current.x + dr[dir];
				int nc = current.y + dc[dir];
				
				if(current.x == R-1 && current.y == C-1) {
					flag = true;
					res = current.dist;
					break;
				}
				
				if(isRange(nr,nc)) {
					if(map[nr][nc] == '.' && !visit[nr][nc][current.wall]) {
						q.add(new Point(nr, nc, current.wall, current.dist+1));
						visit[nr][nc][current.wall] = true;
					}
					else if(map[nr][nc] == '#' && current.wall < K && !visit[nr][nc][current.wall]) {
						q.add(new Point(nr, nc, current.wall+1, current.dist+1));
						visit[nr][nc][current.wall+1] = true;
					}
				}
			}
			if(flag) break;
		}
		
	}
	private static boolean isRange(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
	static class Point {
		int x,y,wall,dist;

		public Point(int x, int y, int wall, int dist) {
			this.x = x;
			this.y = y;
			this.wall = wall;
			this.dist = dist;
		}
		
	}
}
