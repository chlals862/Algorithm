package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 지뢰찾기_4396 {
	static int N;
	static String[][] result;
	static int[][] map;
	static char[][] input, output;
	static boolean[][] visit, resultVisit;
	static int[] dr = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static boolean mine;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		for (int row = 0; row < N; row++) 
			for (int col = 0; col < N; col++) 
				if (input[row][col] == '*') map[row][col] = -1;
		numbering();
		change();
		printMap();
		bw.flush();
		bw.close();
	}
	private static void change() {
		for (int row = 0; row < N; row++) 
			for (int col = 0; col < N; col++) 
				if (resultVisit[row][col] && map[row][col] != -1) result[row][col] = Integer.toString(map[row][col]);
				else if(resultVisit[row][col] && map[row][col] == -1) mine = true;
				else result[row][col] = ".";
		if(mine) 
			for(int row=0;row<N;row++) 
				for(int col=0;col<N;col++) 
					if(map[row][col] == -1) result[row][col] = "*";
		}
	private static void numbering() {
		for (int row = 0; row < N; row++) 
			for (int col = 0; col < N; col++) 
				if (map[row][col] == 0) q.add(new int[] { row, col });
		bfs();
	}
	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for (int dir = 0; dir < 8; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (rangeCheck(nr, nc)) 
						if (map[nr][nc] == -1) map[cr][cc] += 1;
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		result = new String[N][N];
		map = new int[N][N];
		input = new char[N][N];
		output = new char[N][N];
		visit = new boolean[N][N];
		resultVisit = new boolean[N][N];
		for (int row = 0; row < N; row++) {
			String str = br.readLine();
			for (int col = 0; col < N; col++) {
				input[row][col] = str.charAt(col);
			}
		}
		for (int row = 0; row < N; row++) {
			String str = br.readLine();
			for (int col = 0; col < N; col++) {
				output[row][col] = str.charAt(col);
				if (output[row][col] == 'x') resultVisit[row][col] = true;
			}
		}
	}
	private static void printMap() throws IOException {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				bw.write(result[row][col] + "");
			}
			bw.write("\n");
		}
	}
}
