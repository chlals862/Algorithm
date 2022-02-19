package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Prison_Break {
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static char[][] map;
	static boolean[][] visit;
	static int T,C,R,startR,startC,endR,endC;
	static boolean flag;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t=0;t<T;t++) {
			flag = false;
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			Queue<int[]> q = new LinkedList<int[]>();
			map = new char[R][C];
			visit = new boolean[R][C];
			
			startC = Integer.parseInt(st.nextToken())-1;
			startR = Integer.parseInt(st.nextToken())-1;
			endC = Integer.parseInt(st.nextToken())-1;
			endR = Integer.parseInt(st.nextToken())-1;
			
			
			for(int row=R-1;row>=0;row--) map[row] = br.readLine().toCharArray(); 
			char type = map[startR][startC];
			q.add(new int[] {startR,startC,type});
			visit[startR][startC] = true;
			while(!q.isEmpty()) {
				int size = q.size();
				for(int i=0;i<size;i++) {
					int[] currentRC = q.poll();
					int cr = currentRC[0];
					int cc = currentRC[1];
					
					if(cr == endR && cc == endC) {
						flag = true;
						break;
					}
					for(int dir=0;dir<4;dir++) {
						int nr = cr + dr[dir];
						int nc = cc + dc[dir];
						if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
							if(map[nr][nc] == type && !visit[nr][nc]) {
								q.add(new int[] {nr,nc});
								visit[nr][nc] = true;
							}
						}
					}
				}
				if(flag) break;
			}
			q.clear();
			if(flag) bw.write("YES\n");
			else bw.write("NO\n");
		}
		bw.flush();
	}

}
