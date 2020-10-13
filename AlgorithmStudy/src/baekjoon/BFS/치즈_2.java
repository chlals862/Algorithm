package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈_2 {
	static int R,C,count,Time;
	static int[][] map,visit;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		while(true) {
			flag = false;
			visit = new int[R][C];
			q = new LinkedList<int[]>();
			q.add(new int[] {0,0});
			visit[0][0] = 1;
			bfs();
			check();
			Time++;
			if(!flag) break;
		}
		bw.write(Time+"\n");
		bw.flush();
		bw.close();
	}
	private static void check() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] != 0) {
					flag = true;
				}
			}
		}
	}
	private static void bfs() {
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
						if(map[nr][nc] == 0 && visit[nr][nc] == 0) {
							visit[nr][nc] = 1;
							q.add(new int[] {nr,nc});
						} else if(map[nr][nc] == 1) {
							visit[nr][nc]++;
							if(visit[nr][nc] >= 2) {
								map[nr][nc] = 0;
							}
						}
					}
				}
			}
		}	
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
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