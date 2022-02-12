package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 전쟁_전투 {
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int B_num,W_num,C,R;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			map[row] = str.toCharArray();
		}
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(!visit[row][col]) {
					if(map[row][col] == 'B') {
						int num = bfs(row,col,'B');
						B_num += num*num;
					}else if(map[row][col] == 'W') {
						int num = bfs(row,col,'W');
						W_num += num*num;
					}
				}
			}
		}
		bw.write(W_num + " " + B_num+"\n");
		bw.flush();
		bw.close();
	}
	private static int bfs(int row, int col, char color) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {row,col});
		visit[row][col] = true;
		int cnt = 1;
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
						if(map[nr][nc] == color && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							cnt++;
						}
					}
				}
			}
		}
		return cnt;
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}

}
