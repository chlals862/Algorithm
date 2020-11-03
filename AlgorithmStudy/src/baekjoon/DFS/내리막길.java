package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/*

4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
result = 3;
1. 50 45 37 32 20 17 15 10

1 1 1 1 0
0 0 0 1 0
0 0 0 1 0
0 0 0 1 1

2. 50 45 37 32 30 25 20 17 15 10

2 2 2 2 1
0 0 0 2 1
0 0 0 2 0
0 0 0 2 2

3. 50 35 30 27 24 22 15 10

3 2 2 2 1
1 0 0 2 1
1 0 0 2 0
1 1 1 3 3

*/
public class 내리막길 {
	static int R,C;
	static int[][] map;
	static int[][] memo;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		bw.write(dfs(0,0)+"");
		//printMap();
		bw.flush();
		bw.close();
	}
	private static void printMap() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(memo[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static int dfs(int cr, int cc) {
		//System.out.println("DFS 전");
		//printMap();
		if(cr == R-1 && cc == C-1) return 1;
		if(memo[cr][cc] == -1) {
			memo[cr][cc] = 0;
			for(int dir=0;dir<4;dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if(rangeCheck(nr,nc)) {
					if(map[nr][nc] < map[cr][cc]) {
						memo[cr][cc] += dfs(nr,nc);
					}
				}
			}
		}
		//System.out.println("DFS 후");
		//printMap();
		return memo[cr][cc];
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
		memo = new int[R][C];
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				memo[row][col] = -1;
			}
		}
	}
}
