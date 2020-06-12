package 채찍질;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동 {
	static int time;
	static int T;
	static int N;
	static int startR,startC;
	static int endR,endC;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,-2,-2,-1,1,2,2,1};
	static int[] dc = {-2,-1,1,2,2,1,-1,-2};
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		T = Integer.parseInt(br.readLine());

		for(int testCase=0;testCase<T;testCase++) {
			q.clear();
			time = 0;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endR = Integer.parseInt(st.nextToken());
			endC = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			visit = new boolean[N][N];

			q.add(new int[] {startR,startC});
			visit[startR][startC] = true;

			BFS();

			bw.write(time+"\n");


		}
		bw.flush();
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];

				if(cr == endR && cc == endC ) {
					return;
				}
				for(int dir=0;dir<8;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] == 0 && visit[nr][nc] == false) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}
			time++;
		}

	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr>=0 && nr<N && nc>=0 && nc<N) return true;
		return false;
	}

}
