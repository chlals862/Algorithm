package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 헌내기는친구가필요해 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int R, C,people;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			map[row] = str.toCharArray();
		}
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 'I') {
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
						if(map[nr][nc] == 'O' && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
						if(map[nr][nc] == 'P' && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							people++;
						}
					}
				}
			}
		}
		
		if(people > 0 ) bw.write(people+"\n");
		else bw.write("TT");
		bw.flush();
		bw.close();
		
		
//		for(int row=0;row<R;row++) {
//			for(int col=0;col<C;col++) {
//				System.out.print(map[row][col]);
//			}
//			System.out.println();
//		}
		
	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
}
