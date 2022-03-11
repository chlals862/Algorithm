package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 와드 {
	static int R,C,startR,startC;
	static char[][] map;
	static boolean[][] visit;
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
		
		map = new char[R][C];
		visit = new boolean[R][C];
		for(int row=0;row<R;row++) map[row] = br.readLine().toCharArray();
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken())-1;
		startC = Integer.parseInt(st.nextToken())-1;
		char[] dir = br.readLine().toCharArray();
		move(dir);
		last();
		
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] != '.') {
					map[row][col] = '#';
				}
				bw.write(map[row][col] + "");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	private static void last() {
		map[startR][startC] = '.';
		for(int dir=0;dir<4;dir++) {
			int nr = startR + dr[dir];
			int nc = startC + dc[dir];
			if(isRange(nr,nc)) {
				map[nr][nc] = '.';
			}
		}
		
	}
	private static void move(char[] dir) {
		for(int row=0;row<dir.length;row++) {
			switch(dir[row]) {
			case 'L' :
				startC--;
				break;
			case 'R' :
				startC++;
				break;
			case 'U' :
				startR--;
				break;
			case 'D' :
				startR++;
				break;
			case 'W' :
				Ward(startR,startC,map[startR][startC]);
				break;
			}
		}
	}
	private static void Ward(int startR, int startC,char shape) {
		q.add(new int[] {startR,startC});
		visit[startR][startC] = true;
		map[startR][startC] = '.';
		while(!q.isEmpty()) {
			int[] current = q.poll();
			for(int dir=0;dir<4;dir++) {
				int nr = current[0] + dr[dir];
				int nc = current[1] + dc[dir];
				if(isRange(nr,nc) && !visit[nr][nc] && shape == map[nr][nc]) {
					q.add(new int[] {nr,nc});
					visit[nr][nc] = true;
					map[nr][nc] = '.';
				}
			}
		}
	}
	private static boolean isRange(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}

}
