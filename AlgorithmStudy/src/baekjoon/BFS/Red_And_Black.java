package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Red_And_Black {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static char[][] map;
	static boolean[][] visit;
	static int R,C;
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			int count = 1;
			map = new char[R][C];
			visit = new boolean[R][C];
			Queue<int[]> q = new LinkedList<>();
			for(int row=0;row<R;row++) {
				String str = br.readLine();
				map[row] = str.toCharArray();
			}
			
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(map[row][col] == '@') {
						q.add(new int[] {row,col});
						visit[row][col] = true;
					}
				}
			}
			while(!q.isEmpty()) {
				int size = q.size();
				for(int i=0;i<size;i++) {
					int[] currentRC = q.poll();
					for(int dir=0;dir<4;dir++) {
						int nr = currentRC[0] + dr[dir];
						int nc = currentRC[1] + dc[dir];
						if(rangeCheck(nr,nc)) {
							if(map[nr][nc] == '.' && !visit[nr][nc]) {
								q.add(new int[] {nr,nc});
								visit[nr][nc] = true;
								count++;
							}
						}
					}
				}
			}
			
			if(R == 0 && C == 0 ) break;
			bw.write(count+"\n");
		}
		bw.flush();
		bw.close();
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr>=0 && nr< R && nc>=0 && nc<C) return true;
			return false;
	}

}
