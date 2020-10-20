package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연구소 {
	static int resultArea = 0;
	static int R,C;
	static int[][] map;
	static int[][] virus;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 0) {
					map[row][col] = 1;
					dfs(1);
					map[row][col] = 0;
				}
			}
		}
		bw.write(resultArea+"");
		bw.flush();
		bw.close();
	}
	private static void dfs(int wallCount) {
		if(wallCount == 3) {
			virusSpread();
		}else {
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(map[row][col] == 0) {
						map[row][col] = 1;
						dfs(wallCount+1);
						map[row][col] = 0;
					}
				}
			}
		}
		resultArea = checkCount();
	}
	private static int checkCount() {
		int count = 0;
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(virus[row][col] == 0) {
					count++;
				}
			}
		}
		return Math.max(resultArea, count);
	}
	private static void virusSpread() {
		q = new LinkedList<int[]>();
		virus = new int[R][C];
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				virus[row][col] = map[row][col];
			}
		}
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(virus[row][col] == 2) {
					q.add(new int[] {row,col});
				}
			}
		}
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(virus[nr][nc] == 0) {
							virus[nr][nc] = 2;
							q.add(new int[] {nr,nc});
						}
					}
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc <C ) 	return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
