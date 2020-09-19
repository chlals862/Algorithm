package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SpaceExploration {
	static int N;
	static char[][] space;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static ArrayList<Integer> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		list = new ArrayList<Integer>();
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(space[row][col] == '*' && !visit[row][col]) {
					int count = 1;
					q.add(new int[] {row,col});
					visit[row][col] = true;
					list.add(count);
					bfs(count);
				}
			}
		}
		bw.write(list.size()+"\n");
		bw.flush();
		bw.close();
	}
	private static void bfs(int count) {
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
					if(space[nr][nc] == '*' && !visit[nr][nc]) {
						q.add(new int[] {nr,nc});
						visit[nr][nc] = true;
					}
				}
			}
		}
			count++;
	}
}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		space = new char[N][N];
		visit = new boolean[N][N];
		for(int row=0;row<N;row++) {
			String sLine = br.readLine();
			for(int col=0;col<N;col++) {
				space[row][col] = sLine.charAt(col);
			}
		}
	}
}
