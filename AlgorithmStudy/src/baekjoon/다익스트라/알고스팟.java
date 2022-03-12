package baekjoon.다익스트라;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
	int r,c,cnt;
	public Point(int r, int c, int cnt) {
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Point o) {
		return cnt - o.cnt;
	}
}

public class 알고스팟 {
	static int R,C,res;
	static int[][] map;
	static boolean[][] visit;
	static boolean flag;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static PriorityQueue<Point> pq = new PriorityQueue<Point>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			String tmp = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = tmp.charAt(col) -'0';
			}
		}
		pq.add(new Point(0, 0, 0));
		visit[0][0] = true;
		bfs();
		bw.write(res+"\n");
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		while(!pq.isEmpty()) {
			Point current = pq.poll();
			int cr = current.r;
			int cc = current.c;
			int cnt = current.cnt;
			if(cr == R-1 && cc == C-1) {
				res = cnt;
				flag = true;
				break;
			}
			
			for(int dir=0;dir<4;dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if(isRange(nr,nc) && !visit[nr][nc]) {
					if(map[nr][nc] == 0) {
						pq.add(new Point(nr, nc, cnt));
						visit[nr][nc] = true;
					}else if(map[nr][nc] == 1) {
						pq.add(new Point(nr, nc, cnt+1));
						visit[nr][nc] = true;
					}
				}
			}
		}
		
	}
	private static boolean isRange(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}

}
