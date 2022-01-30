package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Spawn_Of_Ungoliant {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int R,C;
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visit = new boolean[R][C];
			Queue<int[]> q = new LinkedList<int[]>();
			for(int row=0;row<R;row++) {
				String str = br.readLine();
				map[row] = str.toCharArray();
			}
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(map[row][col] == 'S') {
						q.add(new int[] {row,col});
						visit[row][col] = true;
					}
				}
			}
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
							if(map[nr][nc] == 'T' && !visit[nr][nc]) {
								map[nr][nc] = 'S';
								q.add(new int[] {nr,nc});
								visit[nr][nc] = true;
							}
						}
					}
				}
			}
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					bw.write(map[row][col]+"");
				}
				bw.write("\n");
			}
			if(R == 0 && C == 0) break;
			q.clear();
		}
		bw.flush();
		bw.close();
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
}
