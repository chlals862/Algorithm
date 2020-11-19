package baekjoon.구현;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class 지뢰찾기_1996 {
	static int N;
	static char[][] input;
	static int[][] map;
	static String[][] result;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0,-1,-1,1,1};
	static int[] dc = {0,1,0,-1,-1,1,1,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		input = new char[N][N]; map = new int[N][N]; result = new String[N][N];
		visit = new boolean[N][N];
		for(int row=0;row<N;row++) {
			String str = br.readLine();
			for(int col=0;col<N;col++) {
				input[row][col] = str.charAt(col);
				if(str.charAt(col) == '.') map[row][col] = 0;
				else {
					map[row][col] = str.charAt(col)-'0';
					visit[row][col] = true;
				}
			}
		}
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(visit[row][col])
					for(int dir=0;dir<8;dir++) {
						int nr = row + dr[dir];
						int nc = col + dc[dir];
						if(rangeCheck(nr,nc) && !visit[nr][nc]) 
							map[nr][nc] += map[row][col];
				}
			}
		}
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(map[row][col] >= 10) result[row][col] = "M";
				else if(visit[row][col]) result[row][col] = "*";
				else result[row][col] = Integer.toString(map[row][col]);
			}
		}
		printMap();
		bw.flush();
		bw.close();
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
			return false;
	}
	private static void printMap() throws IOException {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				bw.write(result[row][col]+"");
			}
			bw.write("\n");
		}
	}
}