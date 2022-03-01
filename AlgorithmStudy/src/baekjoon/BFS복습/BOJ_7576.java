package baekjoon.BFS복습;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//0 익지 않은 토마토
//1 익은 토마토 
//-1 토마토가 들어있지 않은 칸
public class BOJ_7576 {
	static int[][] map;
	static boolean[][] visit;
	static int N,M;
	static Queue<Point> q = new LinkedList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<M;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		find();
		BFS();
		
		if(isFlag()) {
			bw.write(findMax()+"\n");
		}else bw.write(-1+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

	private static int findMax() {
		int max = -1;
		for(int row=0;row<N;row++) {
			for(int col=0;col<M;col++) {
				max = Math.max(max, map[row][col]);
			}
		}
		return max -1;
	}

	private static boolean isFlag() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<M;col++) {
				if(map[row][col] == 0) return false;
			}
		}
		return true;
	}

	private static void BFS() {
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		while(!q.isEmpty()) {
			Point current = q.poll();
			
			for(int dir=0;dir<4;dir++) {
				int nr = current.x + dx[dir];
				int nc = current.y + dy[dir];
				if(rangeCheck(nr,nc) && map[nr][nc] != -1 && !visit[nr][nc]) {
					q.add(new Point(nr, nc, current.day+1));
					visit[nr][nc] = true;
					map[nr][nc] = current.day+1;
				}
			}
		}
		
	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < M) return true;
			return false;
	}

	private static void find() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<M;col++) {
				if(map[row][col] == 1) {
					q.add(new Point(row, col, 1));
					visit[row][col] = true;
				}
			}
		}
		
	}

	static class Point {
		int x,y,day;
		public Point(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
}
