package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Islands {
	static int R,C,result;
	static char[][] map;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
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
		
		bfs();
		bw.write(result+"");
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 'L' && !visit[row][col]) {
					q.add(new int[] {row,col});
					result++;
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
								if(map[nr][nc] == 'L' && !visit[nr][nc]) {
									q.add(new int[] {nr,nc});
									visit[nr][nc] = true;
								}
								if(map[nr][nc] == 'C') {
									map[nr][nc] = 'L';
									q.add(new int[] {nr,nc});
									visit[nr][nc] = true;
								}
							}
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

}
