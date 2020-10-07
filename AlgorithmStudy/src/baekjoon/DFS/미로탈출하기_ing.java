package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 미로탈출하기_ing {
	static int R,C,count;
	static char[][] map;
	static boolean[][] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				visit = new boolean[R][C];
				dfs(row,col);
			}
		}
		System.out.println(count);
		
	}
	private static void dfs(int row, int col) {
		//visit[row][col] = true;
		System.out.println("?");
		if(map[row][col] == 'U') {
			int nr = row-1; int nc = col;
			if(!visit[nr][nc]) {
			if(nr < 0 ) {
				count++;
				visit[nr][nc] = true;
				return;
			}else dfs(nr,nc);
			}
		}
		else if(map[row][col] == 'R') {
			int nr = row; int nc = col+1;
			if(!visit[nr][nc]) {
			if(nc >= C) {
				count++;
				visit[nr][nc] = true;
				return;
			}else dfs(nr,nc);
			}
		}
		else if(map[row][col] == 'D' && !visit[row][col]) {
			System.out.println("dd");
			int nr = row+1; int nc = col;
			if(!visit[nr][nc]) {
			if(nr >= R) {
				count++;
				visit[nr][nc] = true;
				return;
			}else dfs(nr,nc);
			}
		}
		else if(map[row][col] == 'L' && !visit[row][col]) {
			int nr = row; int nc = col-1;
		
			if(nc < 0) {
				if(!visit[nr][nc]) {
				count++;
				visit[nr][nc] = true;
				return;
				}
			}else dfs(nr,nc);
			
		}
		
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = str.charAt(col);
			}
		}
		printData();
	}
	private static void printData() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
