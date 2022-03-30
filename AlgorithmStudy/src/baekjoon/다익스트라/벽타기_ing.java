package baekjoon.다익스트라;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 벽타기_ing {
	static class Point implements Comparable<Point>{
		int x,y,cnt;

		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Point o) {
			return cnt - o.cnt;
		}
	}
	static int R,C,startR,startC,endR,endC;
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
		
		for(int row=0;row<R;row++) {
			map[row] = br.readLine().toCharArray();
			for(int col=0;col<C;col++) {
				if(map[row][col] == 'S') {
					startR = row;
					startC = col;
				}else if(map[row][col] == 'E') {
					endR = row;
					endC = col;
					map[endR][endC] = '#';
				}
			}
		}
		
		bw.write(dijsktra()+"");
		bw.flush();
	}
	private static int dijsktra() {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.add(new Point(startR, startC, 0));
		visit[startR][startC] = true;
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			if(cur.x == endR && cur.y == endC) return cur.cnt;
			for(int dir=0;dir<4;dir++) {
				int nr = cur.x + dr[dir];
				int nc = cur.y + dc[dir];
				if(isRange(nr,nc) && !visit[nr][nc]) {
					if(map[nr][nc] == '.') {
						pq.add(new Point(nr, nc, cur.cnt+1));
						visit[nr][nc] = true;
					}else if(map[nr][nc] == '#') {
						pq.add(new Point(nr, nc, cur.cnt));
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
