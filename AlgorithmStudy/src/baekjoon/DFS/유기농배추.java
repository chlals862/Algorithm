package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 유기농배추 {
	static int T,R,C,K;
	static int vr,vc,area;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static ArrayList<Integer> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			visit = new boolean[R][C];
			list = new ArrayList<Integer>();
			for(int k=0;k<K;k++) {
				st = new StringTokenizer(br.readLine());
				vc = Integer.parseInt(st.nextToken());
				vr = Integer.parseInt(st.nextToken());
				map[vr][vc] = 1;
			}//배추 수
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(map[row][col] == 1 && !visit[row][col]) {
						dfs(row,col);
						list.add(area);
					}
				}
			}
			bw.write(list.size()+"\n");
		}//case
		bw.flush();
		bw.close();
	}
	private static void dfs(int row, int col) {
		visit[row][col] = true;
		area++;
		for(int dir=0;dir<4;dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(rangeCheck(nr,nc) && map[nr][nc] == 1 && !visit[nr][nc]) {
				dfs(nr,nc);
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr <= R-1 && nc >= 0 && nc <= C-1) return true;
		return false;
	}
}
