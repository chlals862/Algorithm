package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 아기상어2 {
	static int R,C,max;
	static int[][] map;
	static int[][] temp;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0,-1,-1,1,1};
	static int[] dc = {0,1,0,-1,-1,1,1,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void bfs() throws IOException {
		int max = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<8;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(temp[nr][nc] > temp[cr][cc]+1) {
							temp[nr][nc] = temp[cr][cc]+1;
							q.add(new int[] {nr,nc});
							max = Math.max(temp[nr][nc], max);
						}
					}
				}
			}
		}
		bw.write(max+"\n");
		bw.flush();
		bw.close();
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
		temp = new int[R][C];
		q = new LinkedList<int[]>();
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				temp[row][col] = Integer.MAX_VALUE;
				if(map[row][col] == 1) {
					q.add(new int[] {row,col});
					temp[row][col] = 0;
				}
			}
		}
		bfs();
	}
}
