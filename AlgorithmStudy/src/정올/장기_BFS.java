package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 장기_BFS {
	static boolean flag;
	static int count;
	static int R,C;
	static int HR,HC,ZR,ZC; //말 행열, 졸 행열
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = {-1,-2,-2,-1,1,2,2,1};
	static int[] dc = {-2,-1,1,2,2,1,-1,-2};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		insertQueue(HR,HC);
		BFS();
		if(flag == true) {
			bw.write(count+"\n");
		}
		bw.flush();
		bw.close();
	}

	private static void insertQueue(int HR, int HC) {
		q.add(new int[] {HR,HC});
		visit[HR][HC] = true;
	}

	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<8;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(cr == ZR && cc == ZC) {
						flag = true;
						return;
					}
					if(rangeCheck(nr,nc) && visit[nr][nc] == false)  {		
						insertQueue(nr,nc);
					}
				}
			}
			count++;
		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
		return false;
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		st = new StringTokenizer(br.readLine());
		HR = Integer.parseInt(st.nextToken());
		HC = Integer.parseInt(st.nextToken());
		ZR = Integer.parseInt(st.nextToken());
		ZC = Integer.parseInt(st.nextToken());
	}
}
