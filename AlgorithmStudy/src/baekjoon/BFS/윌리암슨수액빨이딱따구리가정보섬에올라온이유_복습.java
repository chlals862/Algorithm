package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 윌리암슨수액빨이딱따구리가정보섬에올라온이유_복습 {
	static int N,M,res;
	static int[][] map;
	static int[][] visit;
	static boolean flag;
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new int[N][M];
		
		for(int row=0;row<N;row++) {
			String str = br.readLine();
			for(int col=0;col<M;col++) {
				map[row][col] = str.charAt(col)-'0';
			}
		}
		
		for(int row=0;row<N;row++) {
			for(int col=0;col<M;col++) {
				if(map[row][col] == 2) {
					q.add(new int[] {row,col});
					visit[row][col] = 1;
				}
			}
		}
		
		BFS();
		if(flag) {
			res++;
			bw.write("TAK\n"+res);
		}
		else bw.write("NIE\n");
		bw.flush();
		bw.close();
	}
	private static void BFS() {
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] current = q.poll();
				int cr = current[0];
				int cc = current[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
						if(map[nr][nc] == 0 && visit[nr][nc] == 0) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = 1;
						}
						if(map[nr][nc] > 2) flag = true;
					}
				}
			}
			if(flag) break;
			res++;
		}
		
	}

}
