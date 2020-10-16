package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 전광판전구조작_DFS {
	static int R,C;
	static int whiteCount,blackCount;
	static int[][] map;
	static boolean[][] whiteVisit;
	static boolean[][] blackVisit;
	static ArrayList<Integer> whiteList;
	static ArrayList<Integer> blackList;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	//1 -> white 
	//0 -> black
	private static void logic() throws IOException {
		whiteList = new ArrayList<Integer>();
		blackList = new ArrayList<Integer>();
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				//켜기
				if(map[row][col] == 0 && !whiteVisit[row][col]) {
					white(row,col);
					whiteList.add(whiteCount);
				}
				//끄기
				if(map[row][col] == 1 && !blackVisit[row][col]) {
					black(row,col);
					blackList.add(blackCount);
				}
			}
		}
		bw.write(whiteList.size() + " " + blackList.size());
		bw.flush();
		bw.close();
	}
	private static void black(int cr, int cc) {
		blackVisit[cr][cc] = true;
		for(int dir=0;dir<4;dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == 1 && !blackVisit[nr][nc]) {
					black(nr,nc);
				}
			}
		}
	}
	private static void white(int cr, int cc) {
		whiteVisit[cr][cc] = true;
		for(int dir=0;dir<4;dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == 0 && !whiteVisit[nr][nc]) {
					white(nr,nc);
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
		whiteVisit = new boolean[R][C];
		blackVisit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
