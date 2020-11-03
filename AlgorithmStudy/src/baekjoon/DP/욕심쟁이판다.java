package baekjoon.DP;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
/*
동적계획법
[map]
4
14 9 12 10
1 11 5 4
7 15 2 13
6 3 16 8
   ↓
[memo]
4
1 3 1 2 
3 2 3 4 
2 1 4 1 
3 4 1 2
★★★★★카롱이꺼 참고★★★★★
*/
public class 욕심쟁이판다 {
	static int N,K;
	static int[][] map;
	static int[][] memo;
	static boolean flag;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(memo[row][col] == 0) dfs(row,col);
			}
		}
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				K = Math.max(memo[row][col], K);
			}
		}
		bw.write(K+"");
		bw.flush();
		bw.close();
	}
	private static int dfs(int row, int col) {
		memo[row][col] = 1;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		int currentDay = 1;
		int maxDay = 0;
		for(int dir=0;dir<4;dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[row][col] < map[nr][nc]) {
					if(memo[nr][nc] == 0) currentDay = memo[row][col] + dfs(nr,nc); //메모가 되어 있지 않으면
					else currentDay = memo[row][col] + memo[nr][nc]; //메모가 되어 있다면
					maxDay = Math.max(currentDay, maxDay);
				}
			}
		}
		memo[row][col] = Math.max(memo[row][col], maxDay);
		return memo[row][col];
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N ) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		memo = new int[N][N];
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
	}
}
