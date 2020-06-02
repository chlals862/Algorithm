package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 보물섬_복습 {
	static int R,C;
	static char[][] map;
	static boolean[][] visit;
	static int answer;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new boolean[R][C];
		q = new LinkedList<int[]>();

		for(int i=0;i<R;i++) {
			String sLine = br.readLine();
			map[i] = sLine.toCharArray();
		}
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 'L') {
					visit = new boolean[R][C];
					q.add(new int[] {row,col});
					visit[row][col] = true;
					BFS();
				}
			}
		}
		bw.write(answer-1+"");
		bw.flush();
		bw.close();
	}
	private static void BFS() {
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			time++;
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc) && map[nr][nc] == 'L' && visit[nr][nc] == false) {
						q.add(new int[] {nr,nc});
						visit[nr][nc] = true;
					}
				}
			}
			answer = Math.max(time, answer);
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr <= R-1 && nc >= 0 && nc <= C-1) return true;
		return false;
	}
}
