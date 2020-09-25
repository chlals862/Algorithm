package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 전광판전구조작 {
	static int R,C,whiteN,blackN;
	static int[][] map;
	static boolean[][] bVisit;
	static boolean[][] wVisit;
	static Queue<int[]> q;
	static ArrayList<Integer> black;
	static ArrayList<Integer> white;
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
		bw.write(white.size() + " " + black.size());
		bw.flush();
		bw.close();
		
	}
	private static void logic() {
		q = new LinkedList<int[]>();
		black = new ArrayList<Integer>();
		white = new ArrayList<Integer>();
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 1 && !bVisit[row][col]) {
					int blackN = 1;
					q.add(new int[] {row,col});
					bVisit[row][col] = true;
					black.add(blackN);
					bfs1(blackN);
				}
				if(map[row][col] == 0 && !wVisit[row][col]) {
					int whiteN = 1;
					q.add(new int[] {row,col});
					wVisit[row][col] = true;
					white.add(whiteN);
					bfs2(whiteN);
				}
			}
		}

	}

	private static void bfs2(int whiteN2) {
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
						if(map[nr][nc] == 0 && !wVisit[nr][nc]) {
							q.add(new int[] {nr,nc});
							wVisit[nr][nc] = true;
						}
					}
				}
			}
		}
		
	}
	private static void bfs1(int blackN) {
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
						if(map[nr][nc] == 1 && !bVisit[nr][nc]) {
							q.add(new int[] {nr,nc});
							bVisit[nr][nc] = true;
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
		bVisit = new boolean[R][C];
		wVisit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
