package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 나이트의이동_복습 {
	static int time;
	static int T,N;
	static int[][] map;
	static int ER,EC;
	static boolean[][] visit;
	static boolean flag;
	static Queue<int[]> q;
	static int[] dr = {-1,-2,-2,-1,1,2,2,1};
	static int[] dc = {-2,-1,1,2,2,1,-1,-2};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int testCase = 0; testCase < T; testCase++) {
			q = new LinkedList<int[]>();
			q.clear();
			time = 0;
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			int SR = Integer.parseInt(st.nextToken());
			int SC = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			ER = Integer.parseInt(st.nextToken());
			EC = Integer.parseInt(st.nextToken());
			
			q.add(new int[] {SR,SC});
			visit[SR][SC] = true;
			
			BFS();
			if(SR == ER && SC == EC) {
				bw.write(0+"\n");
			}else {
				bw.write(time+1+"\n");
			}
			
		}
		bw.flush();
		bw.close();
		
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
					
					if(rangeCheck(nr,nc) && visit[nr][nc] == false) {
						if(nr == ER && nc == EC ) {
							return;
						}
						q.add(new int[] {nr,nc});
						visit[nr][nc] = true;
					}
				}
			}
			time++;
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
			return false;
	}
}
