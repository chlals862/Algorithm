package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//for문으로 1~n까지 bfs 돌려서 거리 계산
//mx,my -> 1(x,y)까지 cnt 값 계산후 누적
//visit,q는 for문 끝날때 마다 초기화
public class 치_즈 {
	static class dot {
		int x, y;

		public dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static int R,C,N;
	static char[][]	map;
	static boolean[][] visit;
	static int mx,my,movecnt =0, min = Integer.MAX_VALUE;
	static int result = 0;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<dot> q = new LinkedList<dot>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for(int row=0;row<R;row++) {
			String sLine = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = sLine.charAt(col);
				if(map[row][col] == 'S') {
					mx = row; 
					my = col;
				}
			}
		}
		//1~n치즈 찾기
		for(int row=1;row<=N;row++) {
			result += bfs(row);
			q = new LinkedList<dot>();
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}

	private static int bfs(int c) {
		int cnt = -1;
		visit = new boolean[R][C];
		q.add(new dot(mx, my));
		visit[mx][my] = true;
		boolean end = false;
		while(!q.isEmpty()) {
			cnt++;
			int size = q.size();
			for(int i=0;i<size;i++) {
				dot currentRC = q.poll();
				int cr = currentRC.x;
				int cc = currentRC.y;
				
				if(map[cr][cc] == c+'0') {
					end = true;
					mx = cr;
					my = cc;
					return cnt;
				}
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
					if(map[nr][nc] == 'X') continue;
					if(visit[nr][nc]) continue;
						q.add(new dot(nr, nc));
						visit[nr][nc] = true;
				}
			}//size
			if(end) return cnt;
		}//while
		return 0;
	}
}
