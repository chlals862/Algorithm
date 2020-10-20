package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 파이프옮기기1 {
	static int N,count;
	static int[][] map;
	static int[] dr = {0,1,1};	//가로 세로 대각선
	static int[] dc = {1,0,1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		//0 -> 가로    
		//1 -> 세로
		//2 -> 대각선
		//첫 파이프는 가로 파이프
		dfs(0,1,0);
		bw.write(count+"");
		bw.flush();
		bw.close();
	}
	private static void dfs(int cr, int cc, int shape) {
		if(cr == N-1 && cc == N-1) {
			count++;
			return;
		}
		for(int dir=0;dir<3;dir++) {
			//세로 -> 가로 ,   가로 -> 세로 불가능
			if((shape == 1 && dir == 0) || (shape == 0 && dir == 1)) continue;
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			//범위를 벗어나거나, 벽일 때
			if(!rangeCheck(nr,nc) || map[nr][nc] == 1) continue;
			//대각선인 경우, 확인할 벽
			if(dir == 2 && (map[cr][cc+1] == 1 || map[cr+1][cc] == 1)) continue;
			dfs(nr,nc,dir);
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;	
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[16][16];
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
