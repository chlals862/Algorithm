package CodeUp.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3600 {
	
	static class Point{
		int x,y,step;

		public Point(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}
	static int N;
	static int[][] chess;
	static boolean[][] visit;
	static int startR,startC;
	static int endR,endC;
	static Queue<Point> q = new LinkedList<Point>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		chess = new int[N][N];
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken())-1;
		startC = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		endR = Integer.parseInt(st.nextToken())-1;
		endC = Integer.parseInt(st.nextToken())-1;
		
		bw.write(bfs()+"");
		br.close();
		bw.flush();
		bw.close();
		
	}
	private static int bfs() {
		visit = new boolean[N][N];
		q.add(new Point(startR, startC, 0));
		visit[startR][startC] = true;
		int[] dr = {-1,-2,-2,-1,1,2,2,1};
		int[] dc = {-2,-1,1,2,2,1,-1,-2};
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			for(int dir=0;dir<8;dir++) {
				int nr = now.x + dr[dir];
				int nc = now.y + dc[dir];
				if(now.x == endR && now.y == endC) {
					return now.step;
				}
				if(isRangeCheck(nr,nc) && !visit[nr][nc]) {
					q.add(new Point(nr, nc, now.step+1));
					visit[nr][nc] = true;
				}
			}
		}
		return 0;
	}
	private static boolean isRangeCheck(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
