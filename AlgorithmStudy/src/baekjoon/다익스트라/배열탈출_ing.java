package baekjoon.다익스트라;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 배열탈출_ing {
	static class Point implements Comparable<Point>{
		int x,y,cost;

		public Point(int x, int y, int cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			return cost - o.cost;
		}
	}
	
	
	static int N;
	static int[][] map;
	static int[] dr = {0,1};
	static int[] dc = {1,0};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int res = dijsktra();
		System.out.println(res);
		
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(map[row][col]+" ");
			}
			System.out.println();
		}
	}
	private static int dijsktra() {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.add(new Point(0, 0, 0));
		
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			
			if(cur.x == N-1 && cur.y == N-1) {
				return cur.cost;
			}
			
			for(int dir=0;dir<2;dir++) {
				int nr = cur.x + dr[dir];
				int nc = cur.y + dc[dir];
				if(isRange(nr,nc)) {
					if(map[cur.x][cur.y] <= map[nr][nc]) {
						pq.add(new Point(nr, nc, cur.cost+1));
						map[cur.x][cur.y]+=1;
					}else if(map[cur.x][cur.y] > map[nr][nc]) {
						pq.add(new Point(nr, nc, cur.cost));
					}
					
				}
			}
			
		}
		return 0;
	}
	private static boolean isRange(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}

}
