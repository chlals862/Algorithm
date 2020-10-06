package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 영역구하기 {
	static int R,C,K;
	static int num,count;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] arr;
	static int startR,startC,endR,endC;
	static ArrayList<Integer> list;
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
				if(map[row][col] == 0 && !visit[row][col]) {
					//count++;
					count = 0;
					dfs(row,col);
					list.add(count);
				}
			}
		}
		bw.write(list.size()+"\n");
		Collections.sort(list);
		for(Integer a : list) {
			bw.write(a+1 + " ");
		}
		bw.flush();
		bw.close();
	}
	private static void dfs(int row, int col) {
		visit[row][col] = true;
		for(int dir=0;dir<4;dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == 0 && !visit[nr][nc]) {
					dfs(nr,nc);
					count++;
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
		K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		arr = new int[K];
		list = new ArrayList<Integer>();
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			endR = Integer.parseInt(st.nextToken());
			endC = Integer.parseInt(st.nextToken());
			for(int row=startC;row<endC;row++) {
				for(int col=startR;col<endR;col++) {
					map[row][col] = 1;
					visit[row][col] = true;
				}
			}
		}//case
	}
}
