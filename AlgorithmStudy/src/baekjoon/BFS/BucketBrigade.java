package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BucketBrigade {
	static int result;
	static char[][] farm;
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
		result();
	}
	private static void result() throws IOException {
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}
	private static void logic() {
		q = new LinkedList<int[]>();
		for(int row=0;row<10;row++) {
			for(int col=0;col<10;col++) {
				if(farm[row][col] == 'B' && !visit[row][col]) {
					q.add(new int[] {row,col});
					visit[row][col] = true;
				}
			}
		}
		bfs();
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(farm[nr][nc] == 'L') {
							return;
						}
						if(farm[nr][nc] == '.' && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}
			result++;
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < 10 && nc >= 0 && nc < 10) return true;
			return false;
	}
	private static void setData() throws IOException {
		//st = new StringTokenizer(br.readLine());
		farm = new char[10][10];
		visit = new boolean[10][10];
		for(int row=0;row<10;row++) {
			String sLine = br.readLine();
			for(int col=0;col<10;col++) {
				farm[row][col] = sLine.charAt(col);
			}
		}
	}
}
