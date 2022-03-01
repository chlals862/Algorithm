package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
3 3 10
011
011
000

5

3 3 5
011
111
110

7

10 20 10
00100010110010001010
10110101110101011101
01101010001010011011
11101000011101011110
01100111011111000011
11000000001111111101
01100010010101111001
00000100110010100101
10011010100100010110
11011001110000010100

30



 * */
public class 벽부수고이동하기3 {
	static class Point implements Comparable<Point> {
		int r,c,crash,cnt,day;
		public Point(int r, int c, int crash, int cnt, int day) {
			this.r = r;
			this.c = c;
			this.crash = crash;
			this.cnt = cnt;
			this.day = day;
		}
		@Override
		public int compareTo(Point o) {
			if(this.cnt == o.cnt) {
				return this.cnt - o.cnt;
			} else return this.cnt - o.cnt;
		}
	}
	static int R,C,K;
	static int res = -1;
	static boolean flag;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map;
	static int[][][] visit;
	static PriorityQueue<Point> q = new PriorityQueue<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visit = new int[R][C][11];
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = str.charAt(col)-'0';
			}
		}
		q.add(new Point(0, 0, 0, 1, 1));
		visit[0][0][0] = 1;
		bfs();
		bw.write(res+"\n");
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			Point current = q.poll();
			int cr = current.r;
			int cc = current.c;
			int crash = current.crash;
			int cnt = current.cnt;
			int day = current.day;
			
			if(cr == R-1 && cc == C-1) {
				res = cnt;
				return;
			}
			
			for(int dir=0;dir<4;dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
					
					//벽이 아닐때 -> nr,nc,cnt를 방문한적 있는지 판단
					if(map[nr][nc] == 0 && visit[nr][nc][crash] == 0) {
						q.add(new Point(nr, nc, crash, cnt+1, day*-1));
						visit[nr][nc][crash] = visit[cr][cc][crash];
						
						//벽일때 nr,nc,cnt+1를 방문한적 있는지 -> 현재 낮,밤인지 판단
						//낮인 경우 바로 이동이 가능하기 때문에 부순 벽,이동거리 1씩 증가
					}else if(map[nr][nc] == 1 && crash+1 <= K && visit[nr][nc][crash+1] == 0) {
						
						if(day == 1) { //아침엔 벽 부수기 가능
							q.add(new Point(nr, nc, crash+1, cnt+1, day*-1));
							visit[nr][nc][crash+1] = visit[cr][cc][crash]; 
							
							//밤일떄 바로 이동 안되고, 밤->낮으로 바뀌어야 되기 때문에 벽의수+1,이동거리수+2
						}else  {
							q.add(new Point(nr, nc, crash+1, cnt+2, day));
							visit[nr][nc][crash+1] = visit[cr][cc][crash]; 
						}
					}
				}
			}
		}
		
	}

}
