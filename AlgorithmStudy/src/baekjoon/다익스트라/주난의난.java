package baekjoon.다익스트라;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 주난의난 {
	static class Point implements Comparable<Point>{
		int x,y,jump;

		public Point(int x, int y, int jump) {
			this.x = x;
			this.y = y;
			this.jump = jump;
		}

		@Override
		public int compareTo(Point o) {
			return jump - o.jump;
		}
	}
	static int R,C;
	static int startR,startC,endR,endC;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken())-1;
		startC = Integer.parseInt(st.nextToken())-1;
		endR = Integer.parseInt(st.nextToken())-1;
		endC = Integer.parseInt(st.nextToken())-1;
		
		for(int row=0;row<R;row++) map[row] = br.readLine().toCharArray();
		
		bw.write(dijsktra()+"");
		bw.flush();
	}
	private static int dijsktra() {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.add(new Point(startR, startC, 0));
		visit[startR][startC] = true;
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(cur.x == endR && cur.y == endC) return cur.jump;
			for(int dir=0;dir<4;dir++) {
				int nr = cur.x + dr[dir];
				int nc = cur.y + dc[dir];
				if(isRange(nr,nc) && !visit[nr][nc]) {
					if(map[nr][nc] == '1' || map[nr][nc] == '#') {
						map[nr][nc] = '0';
						visit[nr][nc] = true;
						pq.add(new Point(nr, nc, cur.jump+1));
					}else if(map[nr][nc] == '0') {
						pq.add(new Point(nr, nc, cur.jump));
						visit[nr][nc] = true;
					}
				}
			}
		}
		return 0;
	}
	private static boolean isRange(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}
