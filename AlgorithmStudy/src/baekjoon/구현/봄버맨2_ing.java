package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//짝수초 -> 모든 칸 폭탄 설치

public class 봄버맨2_ing {
	static int R,C,T;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int row=0;row<R;row++) {
			char[] ch = br.readLine().toCharArray();
			for(int col=0;col<C;col++) {
				if(ch[col] == 'O') map[row][col] = 1;
			}
		}
		
		for(int t=1;t<=T;t++) {
			if(T <= 5) {
				if(t % 2 == 0) {
					setting(t);
				}else {
					findBomb(t);
					boom();
				}
			}else if(T > 5) {
				if(t % 2== 0) {
					setting(t);
				}else if(((t+4)%4) == 3) {
					findBomb(t);
					boom();
				}else if(((t+4)%4) == 1) {
					findBomb(t);
					boom();
				}
			}
		}
		
		printMap();
	}
	private static void printMap() {
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
				if (isRange(nr, nc)) {
					map[nr][nc] = 0;
				}
			}
	}
		
	}
	private static boolean isRange(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
	private static void findBomb(int num) {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] <= num-2) q.add(new int[] {row,col});
			}
		}
	}
	private static void setting(int num) {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 0) map[row][col] = num;
			}
		}
		
	}

}
