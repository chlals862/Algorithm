package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 헌내기는친구가필요해_ing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int N, M,people;
	static Queue<int[]> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		map = new char[N][M];
		visit = new boolean[N][M];
		//int people = 0;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') {
					q.add(new int[] { i, j });
					visit[i][j] = true;
				}
			}
		}
		while (!q.isEmpty()) {
			int size = q.size();
			System.out.println("size = " + size);
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = currentRC[0] + dr[dir];
					int nc = currentRC[1] + dc[dir];
					System.out.println(nr + " " + nc);
					
					if (rangeCheck(nr, nc) ) {
						System.out.println("드렁오나");
						if(map[nr][nc] == 'P' && !visit[nr][nc]) {
							people++;
							visit[nr][nc] = true;
						}
					
						else if (map[nr][nc] == 'O' && !visit[nr][nc]) {
							q.add(new int[] { nr, nc });
							visit[nr][nc] = true;
							System.out.println("?");
						}
//						if (map[nr][nc] == 'P' && !visit[nr][nc]) {
//							q.add(new int[] { nr, nc });
//							visit[nr][nc] = true;
//							people++;
//							System.out.println("??");
//						}
						else if (map[nr][nc] == 'X' && !visit[nr][nc]) {
							//q.add(new int[] { nr, nc });
							visit[nr][nc] = true;
							System.out.println("???");
						}
					}
				}
			}
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					System.out.print(visit[i][j] + " ");
				}
				System.out.println();
			}
			
			
			
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(visit[i][j] + " ");
			}
			System.out.println();
		}

		if (people > 0) {
			bw.write(people + "");
		} else
			bw.write("TT");
		bw.flush();
		bw.close();
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nc <= N-1 && nc >= 0 && nc <= M-1) {
			return true;
		}
		return false;
	}

}
