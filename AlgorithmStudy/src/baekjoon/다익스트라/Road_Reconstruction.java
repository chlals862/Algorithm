package baekjoon.다익스트라;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Road_Reconstruction {
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
	//0 -> 단위도로가 이미 존재
	//1 -> 도로에 유실이 없는 상태 , 1의 비용으로 도로를 건설할 수 있는 단위 격자
	//2 -> 단위 도로가 없고 2의 비용으로 도로를 건설할 수 있는 단위격자
	//-1 -> 단위도로를 건설할 수 없는 상태
	static int R,C;
	static int[][] map;
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
		map = new int[R][C];
		visit = new boolean[R][C];
		
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = dijsktra();
		bw.write(ans+"");
		bw.flush();
		bw.close();
	}
	private static int dijsktra() {
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.add(new Point(0, 0, map[0][0]));
		visit[0][0] = true;
		if(map[0][0] == -1) return -1;
		while(!pq.isEmpty()) {
			Point cur = pq.poll();
			if(cur.x == R-1 && cur.y == C-1) return cur.cnt;
			for(int dir=0;dir<4;dir++) {
				int nr = cur.x + dr[dir];
				int nc = cur.y + dc[dir];
				if(isRange(nr,nc) && !visit[nr][nc] && map[nr][nc] != -1) {
					pq.add(new Point(nr, nc, cur.cnt + map[nr][nc]));
					visit[nr][nc] = true;
				}
			}
		}
		return -1;
	}
	private static boolean isRange(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}
