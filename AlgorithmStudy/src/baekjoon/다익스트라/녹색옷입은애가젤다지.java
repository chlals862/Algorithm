package baekjoon.다익스트라;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지 {
	static class Point implements Comparable<Point> {
		int r, c, price;
		public Point(int r, int c, int price) {
			this.r = r;
			this.c = c;
			this.price = price;
		}
		@Override
		public int compareTo(Point o) {
			return price - o.price;
		}
	}
	static int N,res;
	static PriorityQueue<Point> pq = new PriorityQueue<Point>();
	static int[][] map;
	static int[][] cost;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int idx = 1;
		while(true) {
		pq.clear();
		N = Integer.parseInt(br.readLine());
		if(N == 0 ) break;
		map = new int[N][N];
		cost = new int[N][N];
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				cost[row][col] = Integer.MAX_VALUE;
			}
		}
		cost[0][0] = map[0][0];
		dijsktra();
		
		bw.write("Problem "+idx+": "+res+"\n");
		idx++;
		}//while
		bw.flush();
	}

	private static void dijsktra() {
		pq.add(new Point(0, 0, map[0][0]));
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			if(cur.r == N-1 && cur.c == N-1) {
				res = cur.price;
				break;
			}
			
			for(int dir=0;dir<4;dir++) {
				int nr = cur.r + dr[dir];
				int nc = cur.c + dc[dir];
				if(isRange(nr,nc)) {
					if(cost[nr][nc] > cost[cur.r][cur.c] + map[nr][nc]) {
						cost[nr][nc] = cost[cur.r][cur.c] + map[nr][nc];
						pq.add(new Point(nr, nc, cost[nr][nc]));
					}
				}
			}
		}
	}
	private static boolean isRange(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
