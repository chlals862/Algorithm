package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색_복습2 {
	static int R,C,ans;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = str.charAt(col)-'0';
			}
		}
		q = new LinkedList<int[]>();
		q.add(new int[] {0,0});
		visit[0][0] = true;
		ans = 1;
		bfs();
		bw.write(ans+1+"");
		br.close();
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
						if(map[nr][nc] == 1 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							if(nr == R-1 && nc == C-1) return;
						}
						
					}
				}
			}
			ans++;
		}
		
	}

}
