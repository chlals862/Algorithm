package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 모래성 {
	static int R,C,time,count;
	static int[][] map;
	static int[][] temp;
	static boolean[][] visit;
	static boolean flag;
	static int[] dr = {-1,0,1,0,-1,-1,1,1};
	static int[] dc = {0,1,0,-1,-1,1,1,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}

	private static void logic() throws IOException {
		while (true) {
			flag = false;
			visit = new boolean[R][C];
			wave();
			if(!flag) break;
			time++;
		}
		bw.write(time+"");
		bw.flush();
		bw.close();
	}
	private static void wave() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(temp[row][col] > 0 && temp[row][col] <= 8 && !visit[row][col]) {
					int strong = temp[row][col];
					visit[row][col] = true;
					bfs(strong,row,col);
				}
			}
		}
	}
	private static void bfs(int strong,int row,int col) {
		int count = 0;
				for (int dir = 0; dir < 8; dir++) {
					int nr = row + dr[dir];
					int nc = col + dc[dir];
					if (rangeCheck(nr, nc)) {
						if (temp[nr][nc] == 0 && !visit[nr][nc]) {
							count++;
						}
					}
				}
			if(strong <= count) {
				temp[row][col] = 0;
				flag = true;
			}
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
		temp = new int[R][C];
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				if(str.charAt(col) != '.') 
					temp[row][col] = Integer.parseInt(str.substring(col,col+1));
			}
		}
	}
}
