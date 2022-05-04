package SW_EXPERT_ACADEMY.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 물놀이를가자 {
	static class Point {
		int r,c,step;

		public Point(int r, int c, int step) {
			this.r = r;
			this.c = c;
			this.step = step;
		}
	}
	
	static int T,N,M,ans;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<Point> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = 0;
			
			map = new int[N][M];
			visit = new boolean[N][M];
			q = new LinkedList<Point>();
			
			for(int row=0;row<N;row++) {
				String str = br.readLine();
				for(int col=0;col<M;col++) {
					if(str.charAt(col) == 'W') {
						visit[row][col] = true;
						q.add(new Point(row, col, 0));
					}
				}
			}
			
			while(!q.isEmpty()) {
				Point now = q.poll();
				
				for(int dir=0;dir<4;dir++) {
					int nr = now.r + dr[dir];
					int nc = now.c + dc[dir];
					
					if(isRange(nr,nc) && !visit[nr][nc]) {
							q.add(new Point(nr, nc, now.step+1));
							map[nr][nc] = now.step+1;
							visit[nr][nc] = true;
					}
				}
			}
			
			for(int row=0;row<N;row++) {
				for(int col=0;col<M;col++) {
					if(map[row][col] > 0) {
						ans+=map[row][col];
					}
				}
			}
			bw.write("#"+t+" "+ans+"\n");
		}
		bw.flush();
	}
	private static boolean isRange(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < M;
	}
}
