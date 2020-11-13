package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 숫자판점프 {
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static HashSet<String> set;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		map = new int[5][5];
		set = new HashSet<String>(); //중복 제외
		for(int row=0;row<5;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<5;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		logic();
	}
	private static void logic() throws IOException {
		//String temp = new String();
		for(int row=0;row<5;row++) {
			for(int col=0;col<5;col++) {
				dfs(row,col,0,"");
			}
		}
		bw.write(set.size()+"\n");
		bw.flush();
		bw.close();
	}
	private static void dfs(int row, int col, int length,String temp) {
		if(length == 6) {
			set.add(temp);
			return;
		}else {
			for(int dir=0;dir<4;dir++) {
				int nr = row+dr[dir];
				int nc = col+dc[dir];
				int num = map[row][col];
				if(rangeCheck(nr,nc)) {
					dfs(nr,nc,length+1,temp+num);//문자열 1, 11 111 1112 ...
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < 5 && nc >= 0 && nc < 5) return true;;
			return false;
	}
}
