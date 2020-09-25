package SW_EXPERT_ACADEMY.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로1 {
	static int T;
	static char[][] maze;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static StringTokenizer st;
	static boolean flag;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <=10; t++) {
			T = Integer.parseInt(br.readLine());
			maze = new char[16][16];
			visit = new boolean[16][16];
			q = new LinkedList<int[]>();
			flag = false;
			for (int row = 0; row < 16; row++) {
				String sLine = br.readLine();
				for (int col = 0; col < 16; col++) {
					maze[row][col] = sLine.charAt(col);
					if (maze[row][col] == '2' && !visit[row][col]) {
						q.add(new int[] { row, col });
						visit[row][col] = true;

					}
				}
			}
			bfs();
			if (flag) {
				bw.write("#"+t+" "+1+"\n");
			} else bw.write("#"+t+" "+0+"\n");
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
						if (maze[nr][nc] == '3') {
							flag = true;
							break;
						}
						if (maze[nr][nc] == '0' && !visit[nr][nc]) {
							q.add(new int[] { nr, nc });
							visit[nr][nc] = true;
						}
					}
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < 16 && nc >= 0 && nc < 16)
			return true;
		return false;
	}
}
