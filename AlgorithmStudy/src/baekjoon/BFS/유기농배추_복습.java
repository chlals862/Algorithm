package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추_복습 {
	static List<Integer> list;
	static int area;
	static int cabbageR,cabbageC;
	static int T,R,C,K;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] land;
	static boolean[][] visit;
	static Queue<int[]>q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
	}
	private static void setData() throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		for(int testCase=0;testCase<T;testCase++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			land = new int[R][C];
			visit = new boolean[R][C];
			list = new ArrayList<Integer>();
			for(int k=0;k<K;k++) {
				st = new StringTokenizer(br.readLine());
				cabbageC = Integer.parseInt(st.nextToken());
				cabbageR = Integer.parseInt(st.nextToken());
				land[cabbageR][cabbageC] = 1;
			}
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(land[row][col] == 1 && visit[row][col] == false) {
						q.clear();
						q.add(new int[] {row,col});
						visit[row][col] = true;
						area = 1;
						BFS();
						list.add(area);
					}
				}
			}
			bw.write(list.size() + "\n");
		}
		bw.flush();
		bw.close();
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];

				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];

					if(rangeCheck(nr,nc) && land[nr][nc] == 1 && visit[nr][nc] == false) {
						q.add(new int[] {nr,nc});
						visit[nr][nc] = true;
					}
				}
			}
		}

	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr <= R-1 && nc >= 0 && nc <= C-1) return true;
		return false;
	}
}
