package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 영상처리 {
	static int N,M,result;
	static double[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int T;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new double[N][M];
		visit = new boolean[N][M];
		
		for(int row=0;row<N;row++) { 
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<M;col++) {
				double rgb = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
				map[row][col] = rgb/3;
			}
		}
		T = Integer.parseInt(br.readLine());
		for(int row=0;row<N;row++) {
			for(int col=0;col<M;col++) {
				if(map[row][col] < T) map[row][col] = 0;
				else if(map[row][col] >= T) map[row][col] = 255;
			}
		}
		
		for(int row=0;row<N;row++) {
			for(int col=0;col<M;col++) {
				if(map[row][col] == 255 && !visit[row][col]) {
					bfs(row,col);
					result++;
				}
			}
		}
		
		bw.write(result+"\n");
		bw.flush();
		bw.close();
		

	}
	private static void bfs(int row, int col) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {row,col});
		visit[row][col] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
						if(map[nr][nc] == 255 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}
		}
	}

}
