package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 그림판채우기 {
	static char[][] map;
	static int[][] visit;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int startR,startC;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		if(visit[startC][startR] == 1 && map[startC][startR] == '*') {
			check();
			printMap();
			return;
		}
		if(visit[startC][startR] == 0 && map[startC][startR] == '_') {
			q.add(new int[] {startC,startR});
			map[startC][startR] = '*';
			bfs();
		}
		printMap();
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr+dr[dir];
					int nc = cc+dc[dir];
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] == '_' && visit[nr][nc] == 0) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = 1;
							map[nr][nc] = '*';
						}
					}
				}
			}
		}
	}
	private static void check() {
		q.add(new int[] {0,0});
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
						if(map[nr][nc] == '_' && visit[nr][nc] == 0) {
							map[nr][nc] = '*';
							visit[nr][nc] = 1;
							q.add(new int[] {nr,nc});
						}
					}
				}
			}
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < 10 && nc >= 0 && nc < 10) return true;
			return false;
	}
	private static void setData() throws IOException {
		map = new char[10][10];
		visit = new int[10][10];
		for(int row=0;row<10;row++) {
			String str = br.readLine();
			for(int col=0;col<10;col++) {
				map[row][col] = str.charAt(col);
			}
		}
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken());
		startC = Integer.parseInt(st.nextToken());
	}
	private static void printMap() throws IOException {
		for(int row=0;row<10;row++) {
			for(int col=0;col<10;col++) {
				bw.write(map[row][col]+"");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
