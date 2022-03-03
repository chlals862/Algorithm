package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 농장관리 {
	static class Point {
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
	static int[] dr = {-1,-1,-1,0,1,1,1,0,};
	static int[] dc = {-1,0,1,1,1,0,-1,-1};
	static boolean topCheck;
	static Queue<Point> q = new LinkedList<>();
	static int[][] map;
	static boolean[][] visit;
	static int N,M,res;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		logic();
		bw.write(res+"\n");
		bw.flush();
	}
	private static void logic() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<M;col++) {
				if(!visit[row][col]) {
					topCheck = true;
					bfs(row,col,map[row][col]);
					if(topCheck) res++;
				}
			}
		}
		
	}
	private static void bfs(int row, int col, int height) {
		q.add(new Point(row, col));
		visit[row][col] = true;
		
		while(!q.isEmpty()) {
			Point current = q.poll();
			for(int dir=0;dir<8;dir++) {
				int nr = current.x + dr[dir];
				int nc = current.y + dc[dir];
				
				if(isRange(nr,nc)) {
					if(height < map[nr][nc]) {
						topCheck = false;
					}else if(map[nr][nc] == height && !visit[nr][nc]) {
						q.add(new Point(nr,nc));
						visit[nr][nc] = true;
					}
				
				}
			}
		}
		
		
	}
	private static boolean isRange(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
			return false;
	}

}
