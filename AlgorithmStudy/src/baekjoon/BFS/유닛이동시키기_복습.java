package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유닛이동시키기_복습 {
	static boolean flag;
	static int moveCount;
	static int R,C;
	static int A,B;
	static int K;
	static int WR,WC;
	static int SR,SC,GR,GC;
	static int[][] map;
	static boolean[][] visit;	
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
		printData();
	}
	private static void printData() throws IOException {
		if(flag == true) {
			bw.write(moveCount+"\n");
		}else {
			bw.write(-1+"\n");
		}
		bw.flush();
		bw.close();
	}
	private static void logic() {
		q = new LinkedList<int[]>();
		q.add(new int[] {SR-1,SC-1});
		visit[SR-1][SC-1] = true;
		BFS();
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if(cr == GR-1 && cc == GC-1) {
					flag = true;
					return;
				}
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];

					if(rangeCheck(nr,nc) && checkWall(nr,nc) && visit[nr][nc] == false) {
						q.add(new int[] {nr,nc});
						visit[nr][nc] = true;
					}
				}
			}
			moveCount++;
		}
	}
	private static boolean checkWall(int nr, int nc) {
		if(nr+A <= R && nc+B <= C) {
			for(int row=nr; row<nr+A;row++) {
				for(int col=nc; col<nc+B;col++) {
					if(map[row][col] == 1) return false;
				}
			}
		}else return false;
		return true;
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visit = new boolean[R][C];

		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			WR = Integer.parseInt(st.nextToken());
			WC = Integer.parseInt(st.nextToken());
			map[WR-1][WC-1] = 1;
		}
		st = new StringTokenizer(br.readLine());
		SR = Integer.parseInt(st.nextToken());
		SC = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		GR = Integer.parseInt(st.nextToken());
		GC = Integer.parseInt(st.nextToken());
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
		return false;
	}
}
