package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 빗물 {
	static int R, C, cnt;
	static int[][] map;
	static boolean[][] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		String[] str = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		map = new int[R][C];
		visit = new boolean[R][C];
		String[] input = br.readLine().split(" ");
		for (int col = 0; col < C; col++) {
			int k = Integer.parseInt(input[col]);
			for (int row = 0; row < k; row++) {
				map[row][col] = 1;
			}
		}
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 1 && !visit[row][col]) {
					visit[row][col] = true;
					dfs(row,col);
				}
			}
		}
		printMap();
		bw.write(cnt+"");
		bw.flush();
		bw.close();
	}

	private static void dfs(int row, int col) {
		int nc = col;
		while(true) {
			nc++;
			if(nc>=C) break;
			if(map[row][nc] == 1) {
				cnt+=(nc-col-1);
				break;
			}
			visit[row][nc] = true;
		}
		
	}

	private static void printMap() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
}
