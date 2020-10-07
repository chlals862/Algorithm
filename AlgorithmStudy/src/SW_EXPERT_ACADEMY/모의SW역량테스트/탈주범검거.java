package SW_EXPERT_ACADEMY.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
1 - 1,2,3,4,5,6,7
2 - 위 - 1,2,5,6  아래 - 1,2,4,7
3 - 왼 - 1,3,4    오 - 1,3,6,7
4 - 위 - 1,2,5,6  오 - 1,3,6,7
5 - 아래 - 1,2,4,7 오 - 1,3,6,7
6 - 왼 - 1,3,4 아래 - 1,2,4,7
7 - 왼 - 1,3,4 위 - 1,2,5,6
------------------------------------------
왼 - 1,3,4
오 - 1,3,6,7
위 - 1,2,5,6
아래 - 1,2,4,7


*/
public class 탈주범검거 {
	
	static int T,R,C,startR,startC,time,timeCount;
	static int count;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			time = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			visit = new boolean[R][C];
			q = new LinkedList<int[]>();
			count = 0;
			for(int row=0;row<R;row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0;col<C;col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			logic(t);
		}
		//bw.close();
	}

	private static void logic(int t) throws IOException {
		q.add(new int[] {startR,startC});
		visit[startR][startC] = true;
		count++;
		timeCount = 1;
		bfs();
		bw.write("#"+t+" "+count+"\n");
		bw.flush();
		
	}
	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int k = 0; k < size; k++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				int type = map[cr][cc];
				if(timeCount == time) return;
									
						if(type == 1) {
							if(up(cr,cc) && map[cr-1][cc] != 0) {
								queAdd(cr-1,cc);
							}
							if(down(cr,cc) && map[cr+1][cc] != 0) {
								queAdd(cr+1,cc);
							}
							if(left(cr,cc) && map[cr][cc-1] != 0) {
								queAdd(cr,cc-1);
							}
							if(right(cr,cc) && map[cr][cc+1] != 0) {
								queAdd(cr,cc+1);
							}
						}
						//위 아래  -> 위 : 1 2 5 6, 아래 : 1 2 4 7
						if(type == 2) {
							if(up(cr,cc) && map[cr-1][cc] != 0) {
								queAdd(cr-1,cc);
							}
							if(down(cr,cc) && map[cr+1][cc] != 0) {
								queAdd(cr+1,cc);
							}
						}
						//왼 오 -> 왼 : 1 3 4 5, 아래 : 1 2 4 7
						if(type == 3) {
							if(left(cr,cc) && map[cr][cc-1] != 0) {
								queAdd(cr,cc-1);	
							}
							if(right(cr,cc) && map[cr][cc+1] != 0) {
								queAdd(cr,cc+1);
							}
						}
						//위 오 -> 위 : 1 2 5 6, 오 : 1 3 6 7
						if(type == 4) {
							if(up(cr,cc) && map[cr-1][cc] != 0) {
								queAdd(cr-1,cc);
							}
							if(right(cr,cc) && map[cr][cc+1] != 0) {
								queAdd(cr,cc+1);
							}
						}
						//아래 오 -> 아래 : 1 2 4 7, 오 : 1 3 6 7
						if(type == 5) {
							if(down(cr,cc) && map[cr+1][cc] != 0) {
								queAdd(cr+1,cc);
							}
							if(right(cr,cc)&& map[cr][cc+1] != 0) {
								queAdd(cr,cc+1);
							}
						}
						//왼 아래 -> 왼 : 1 3 4 5, 아래 : 1 2 4 7
						if(type == 6) {
							if(left(cr,cc)) {
								queAdd(cr,cc-1);
							}
							if(down(cr,cc)) {
								queAdd(cr+1,cc);
							}
						}
						//왼 위 -> 왼 : 1 3 4 5, 위 : 1 2 5 6
						if(type == 7) {
							if(left(cr,cc)) {
								queAdd(cr,cc-1);
							}
							if(up(cr,cc)) {
								queAdd(cr-1,cc);
							}
						}
			}
			timeCount++;
		}
	}
	private static boolean right(int cr, int cc) {
		if(rangeCheck(cr,cc+1) 
				&& (map[cr][cc+1] == 1 
				|| map[cr][cc+1] == 3 
				|| map[cr][cc+1] == 6 
				|| map[cr][cc+1] == 7) 
				&& !visit[cr][cc+1]) 
			return true;
		return false;
	}

	private static boolean left(int cr, int cc) {
		if(rangeCheck(cr,cc-1) 
				&& (map[cr][cc-1] == 1 
				|| map[cr][cc-1] == 3 
				|| map[cr][cc-1] == 4 
				|| map[cr][cc-1] == 5) 
				&& !visit[cr][cc-1]) 
			return true;
		return false;
	}
	
	private static boolean down(int cr, int cc) {
		if(rangeCheck(cr+1,cc) 
				&& (map[cr+1][cc] == 1 
				|| map[cr+1][cc] == 2 
				|| map[cr+1][cc] == 4 
				|| map[cr+1][cc] == 7) 
				&& !visit[cr+1][cc]) 
			return true;
		return false;
	}

	private static boolean up(int cr, int cc) {
		if(rangeCheck(cr-1, cc) 
				&& (map[cr-1][cc] == 1 
				|| map[cr-1][cc] == 2 
				|| map[cr-1][cc] == 5 
				|| map[cr-1][cc] == 6) 
				&& !visit[cr-1][cc]) 
			return true;
			return false;
	}

	private static void queAdd(int nr, int nc) {
		q.add(new int[] {nr,nc});
		visit[nr][nc] = true;
		count++;
	}

	private static boolean rangeCheck(int cr, int cc) {
		if(cr >= 0 && cr < R && cc >= 0 && cc < C) return true;
			return false;
	}
}
