package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바닥장식_ing {
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static boolean[][] visit;
	static int R,C;
	// '-' 는 행별 'ㅣ'는 열별
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		int count = 0;
		Queue<int[]> q = new LinkedList<int[]>();
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			map[row] = str.toCharArray();
		}
		
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == '-' && !visit[row][col]) {
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
						if(map[cr][cc] == '-') {
							
							if(map[cr][nc] == '-' && !visit[cr][nc]) {
								System.out.println(">");
								q.add(new int[] {cr,nc});
								visit[cr][nc] = true;
								count++;
							}
						}
						if(map[cr][cc] == '|') {
							if(map[nr][cc] == '|' && !visit[nr][cc]) {
								q.add(new int[] {cr,nc});
								visit[cr][nc] = true;
								count++;
							}
						}
					}
				}
			}
		}
		System.out.println(count);
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}

}
