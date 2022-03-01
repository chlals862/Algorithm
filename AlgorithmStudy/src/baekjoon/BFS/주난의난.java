package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 주난의난 {
	
	static class Point {
		int row,col,cnt;

		public Point(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
		
	}
	static int R,C,startR,startC,endR,endC,res;
	static boolean[][] visit;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean flag;
	static Queue<Point> q = new LinkedList<Point>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		visit = new boolean[R][C];
		map = new int[R][C];
		
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken())-1;
		startC = Integer.parseInt(st.nextToken())-1;
		endR = Integer.parseInt(st.nextToken())-1;
		endC = Integer.parseInt(st.nextToken())-1;
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = str.charAt(col)-'0';
			}
		}
		map[startR][startC] = 2; map[endR][endC] = 3;
		
		q.add(new Point(startR, startC, 1));
		visit[startR][startC] = true;
		
		while(!q.isEmpty()) { 
				Point current = q.poll();
				int cr = current.row;
				int cc = current.col;
				int cnt = current.cnt;
				if(cr == endR && cc == endC) {
					flag = true;
					res = cnt;
				}
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nr][nc]) {
						visit[nr][nc] = true;
						if(map[nr][nc] == 1) {
							q.add(new Point(nr,nc,cnt+1));
							map[nr][nc] = 0;
						}else q.add(new Point(nr,nc,cnt));
					}
				}
				
			if(flag)break;
			
			System.out.println();
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					System.out.print(map[row][col]+" ");
				}
				System.out.println();
			}
		}
		
		
		
		bw.write(res+"\n");
		bw.flush();
	}
	

}
