package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CowBeautyPageant {
	static int R,C,num;
	static char[][] map;
	static int[][] tempMap;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() {
		q = new LinkedList<int[]>();
		int num = 1;
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(tempMap[row][col] == 1 && !visit[row][col]) {
					q.add(new int[] {row,col});
					visit[row][col] = true;
					numbering(num);
					num++;
				}
			}
		}
		printData();
	}
	private static void numbering(int num) {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] cr = q.poll();
				for(int dir=0;dir<4;dir++) {
					int nr = cr[0] + dr[dir];
					int nc = cr[1] + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(tempMap[nr][nc] != 0 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							tempMap[nr][nc] = num;
						}
					}
				}
			}
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
		map = new char[R][C];
		tempMap = new int[R][C];
		visit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			String sLine = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = sLine.charAt(col);
				if(map[row][col] == 'X') {
					tempMap[row][col] = 1;
				}
			}
		}
	}
	private static void printData() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(tempMap[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
