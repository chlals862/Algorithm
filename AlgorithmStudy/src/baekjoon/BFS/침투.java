package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 침투 {
	static char[][] map;
	static boolean[][] visit;
	static boolean flag;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int R, C;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new boolean[R][C];

		for (int row = 0; row < R; row++) {
			String sLine = br.readLine();
			for (int col = 0; col < C; col++) {
				map[row][col] = sLine.charAt(col);
			}
		}
		logic();
	}
	private static void logic() throws IOException {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[0][col] == '0' && !visit[0][col]) {
					q.add(new int[] {0,col});
					visit[0][col] = true;
					bfs();
				}
			}
		}
		for(int col=0;col<C;col++) {
			if(visit[R-1][col] == true) {
				flag = true;
			}
		}
		if(flag == true) {
			bw.write("YES" + "\n");
		} else {
			bw.write("NO" + "\n");
		}
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (rangeCheck(nr, nc)) {
						if (map[nr][nc] == '0' && !visit[nr][nc]) {
							q.add(new int[] { nr, nc });
							visit[nr][nc] = true;
						}
					}
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}
	
}
