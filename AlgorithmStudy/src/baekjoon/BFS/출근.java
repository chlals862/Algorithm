package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 출근 {
	static int R,C,N,cnt;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr,dc;
	static Queue<int[]> q;
	static boolean flag;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		q = new LinkedList<int[]>();
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dr = new int[N];
		dc = new int[N];
		for(int n=0;n<N;n++) {
			st = new StringTokenizer(br.readLine());
			dr[n] = Integer.parseInt(st.nextToken());
			dc[n] = Integer.parseInt(st.nextToken());
		}
		for(int col=0;col<C;col++) {
			if(map[0][col] == 1) {
				q.add(new int[] {0,col});
				visit[0][col] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if(cr == R-1) {
					flag = true;
					break;
				}
				for(int dir=0;dir<N;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
						if(map[nr][nc] == 1 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}
			if(flag) break;
			cnt++;
			
		}
		if(flag) bw.write(cnt+"");
		else bw.write(-1+"");
		br.close();
		bw.flush();
		bw.close();
	}

}
