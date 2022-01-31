package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
1
7 8
XXXXXXXX
XSOOXOOX
XOXOOOOX
XOXXXOOX
XOXOXXOX
XOOOXOOX
XXXXXGXX
*/
public class Robot_In_a_Maze_ing {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int T,R,C;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			char[][] map = new char[R][C];
			boolean[][] visit = new boolean[R][C];
			Queue<int[]> q = new LinkedList<int[]>();
			boolean flag = false;
			int count = 0;
			
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
					int[] currentRC	= q.poll();
					int cr = currentRC[0];
					int cc = currentRC[1];
					for(int dir=0;dir<4;dir++) {
						int nr = cr + dr[dir];
						int nc = cc + dc[dir];
						if(rangeCheck(nr,nc)) {
							if(map[nr][nc] == 'O' && !visit[nr][nc]) {
								q.add(new int[] {nr,nc});
								visit[nr][nc] = true;
							}
							if(map[nr][nc] == 'G') {
								flag = true;
								break;
							}
						}
					}
				}
				count++;
			}
			
			if(flag) {
				System.out.println("Shortest Path: "+count);
			}else System.out.println("No Exit");

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
