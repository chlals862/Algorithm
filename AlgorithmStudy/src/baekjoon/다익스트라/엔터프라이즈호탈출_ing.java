package baekjoon.다익스트라;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 엔터프라이즈호탈출_ing {
	static class Point implements Comparable<Point>{
		int x,y,time;

		public Point(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
		@Override
		public int compareTo(Point o) {
			return this.time - o.time;
		}
	}
	
	static int T,K,R,C;
	static int[][] map;
	static boolean[][] visit;
	static int[] cost;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Point start;
	static PriorityQueue<Point> pq = new PriorityQueue<Point>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		
		while(T --> 0) {
			pq.clear();
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[R+2][C+2];
			visit = new boolean[R+2][C+2];
			cost = new int[26];
			
			for(int k=0;k<K;k++) {
				st = new StringTokenizer(br.readLine());
				cost[st.nextToken().charAt(0)-'A'] = Integer.parseInt(st.nextToken());
			}
			for(int row=1;row<=R;row++) {
				String str = br.readLine();
				for(int col=1;col<=C;col++) {
					map[row][col] = cost[str.charAt(col-1)-'A'];
					if(str.charAt(col-1) == 'E') {
						start = new Point(row, col, 0);
						map[row][col] = 0;
					}
				}
			}
			
			bw.write(result()+"\n");
		}
		bw.flush();
	}
	private static int result() {
		visit[start.x][start.y] = true;
		pq.add(start);
		while(!pq.isEmpty()) {
			Point current = pq.poll();
			if(current.x == 0 || current.y == 0 || current.x == R+1 || current.y == C+1) return current.time;
			
			for(int dir=0;dir<4;dir++) {
				int nr = current.x + dr[dir];
				int nc = current.y + dc[dir];
				if(isRange(nr,nc) && !visit[nr][nc]) {
					pq.add(new Point(nr, nc, current.time + map[nr][nc]));
					visit[nr][nc] = true;
				}
			}
		}
		return 0;
	}
	private static boolean isRange(int nr, int nc) {
		return nr >= 0 && nr < R+1 && nc >= 0 && nc < C+1;
	}

}
