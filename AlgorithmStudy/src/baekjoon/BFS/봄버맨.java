package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 봄버맨 {
	static int R, C, T;
	static int time;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		//time = 1;
		for (int row = 0; row < R; row++) {
			char[] ch = br.readLine().toCharArray();
			for (int col = 0; col < C; col++) {
				if(ch[col] == '.') map[row][col] = 0;
				else map[row][col] = 1;
			}
		}
		for(int t=0;t<=T;t++) {
			if(t % 2 == 0) setBoom(t);
			else {
				findBoom(t);
				boom();
			}
		}
		printMap();
	}

	private static void printMap() throws IOException {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 0) map[row][col] = '.';
				else map[row][col] = 'O';
				System.out.format("%c", map[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void boom() {
		while (!q.isEmpty()) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				map[cr][cc] = 0;
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (rangeCheck(nr, nc)) {
						map[nr][nc] = 0;
					}
				}
		}
	}
	private static void findBoom(int num) {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] <= num -2) q.add(new int[] {row,col});
			}
		}
	}

	private static void setBoom(int num) {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 0) map[row][col] = num;
			}
		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}
}
