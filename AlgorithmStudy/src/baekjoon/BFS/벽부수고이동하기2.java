package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기2 {
	
	public static class Point{
		int r;
		int c;
		int crash;
		int cnt;
		public Point(int r, int c, int crash,int cnt) {
			this.r = r;
			this.c = c;
			this.crash = crash;
			this.cnt = cnt;
		}
	}
	static int R,C,K,res;
	static int map[][];
	static boolean[][][] visit;
	static int dr[] = {-1,0,1,0};
	static int dc[] = {0,1,0,-1};
	static boolean flag;
	static Queue<Point> q = new LinkedList<Point>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String args[]) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visit = new boolean[R][C][11];
		
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = str.charAt(col)-'0';
			}
		}
		
		if(map[0][0] == 0) {
			q.add(new Point(0, 0, 0,1));
			visit[0][0][K] = true;
		}
		
		bfs();
		if(flag) bw.write(res+"\n");
		else bw.write(-1+"\n"); //도착 못했을떄 -1 출력하는걸 안했었다............................................
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			Point current = q.poll();
			int cr = current.r;
			int cc = current.c;
			int crash = current.crash;
			int cnt = current.cnt;
			if(cr == R-1 && cc == C-1) {
				flag = true;
				res = cnt;
				break;
			}
			
			for(int dir=0;dir<4;dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if(map[nr][nc] == 0 && !visit[nr][nc][crash]) {
						q.add(new Point(nr, nc, crash,cnt+1));
						visit[nr][nc][crash] = true;
					}
					else if(map[nr][nc] == 1 && crash < K && !visit[nr][nc][crash]) {
						q.add(new Point(nr, nc, crash+1,cnt+1));
						visit[nr][nc][crash] = true;
					}
				}
			}
			if(flag) break;
		}
		
	}
}

