package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 직사각형탈출 {
	static int R, C, moveCnt;
	static int A, B, startR, startC, endR, endC;
	static int[][] map;
	static int[][] visit;
	static boolean flag;
	static Queue<int[]> q;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
		result();
	}

	private static void result() throws IOException {
		if (flag) {
			bw.write(moveCnt + "\n");
		} else
			bw.write(-1 + "\n");
		bw.flush();
		bw.close();
	}

	private static void logic() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 1) {
					rangeCheck(row,col);
				}
			}
		}
		q = new LinkedList<int[]>();
		q.add(new int[] { startR,startC});
		visit[startR][startC] = 1;
		bfs();
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if (cr == endR&& cc == endC) {
					flag = true;
					return;
				}
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (nr>=0 &&  nr<R-A+1 && nc>=0 && nc<C-B+1 && visit[nr][nc] == 0) {
						q.add(new int[] { nr, nc });
						visit[nr][nc] = 1;
					}
				}
			}
			moveCnt++;
		}

	}

	private static void rangeCheck(int nr, int nc) {
		for(int row = nr-(A-1); row<=nr;row++) {
			for(int col=nc-(B-1); col<=nc; col++) {
				if(row>= 0 && row<R && col>= 0 && col<C) {
					visit[row][col] = 1;
				}
			}
		}
	}


	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new int[R][C];
		for (int row = 0; row < R; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < C; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		startR = Integer.parseInt(st.nextToken())-1;
		startC = Integer.parseInt(st.nextToken())-1;
		endR = Integer.parseInt(st.nextToken())-1;
		endC = Integer.parseInt(st.nextToken())-1;
	}
}
