package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기1_복습 {
	static int time;
	static int R,C;
	static boolean flag;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static char[][] map;
	static boolean[][][] visit;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new boolean[R][C][2];
		q = new LinkedList<int[]>();
		for(int row=0;row<R;row++) {
			String sLine = br.readLine();
			for(int col=0;col<C;col++) {
				map[row] = sLine.toCharArray();
			}
		}
		q.add(new int[] {0,0,1});
		visit[0][0][1] = true;

		BFS();

		if(flag == true) {
			bw.write(time+1+"\n");
		}else {
			bw.write(-1+"\n");
		}
		bw.flush();
		bw.close();
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				int ca = currentRC[2];
				if(cr == R-1 && cc == C-1 ) {
					flag = true;
					return;
				}
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] == '0' && visit[nr][nc][ca] == false) {
							q.add(new int[] {nr,nc,ca});
							visit[nr][nc][ca] = true;
						}
					}
					if(ca > 0 ) {
						if(rangeCheck(nr,nc)) {
							if(map[nr][nc] == '0' || map[nr][nc] == '1' && visit[nr][nc][ca-1] == false) {
								map[nr][nc] = '0';
								q.add(new int[] {nr,nc,ca-1});
								visit[nr][nc][ca-1] = true;
							}
						}
					}
				}
			}
			time++;
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >=0 && nr < R && nc >= 0 && nc < C) return true;
		return false;
	}
}
