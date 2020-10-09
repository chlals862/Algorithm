package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 호수찾기 {
	static int R,C,T,cnt,max = Integer.MIN_VALUE;
	static int waterR,waterC;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] lake;
	static boolean[][] visit;
	static Queue<int[]> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(lake[row][col] == 1 && !visit[row][col]) {
					q.add(new int[] {row,col});
					visit[row][col] = true;
					cnt = 1;
					bfs();
					max = (Math.max(max, cnt) == max ) ? max : cnt;
				}
			}
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		
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
						if(lake[nr][nc] == 1 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							cnt++;
						}
					}
				}
			}
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
		T = Integer.parseInt(st.nextToken());
		lake = new int[R][C];
		visit = new boolean[R][C];
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			waterR = Integer.parseInt(st.nextToken())-1;
			waterC = Integer.parseInt(st.nextToken())-1;
			lake[waterR][waterC] = 1;
		}
	}
}
