package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//벽[1]이 있는곳을 땅이라고 변경 시 BFS로 이동할 수 있는 칸수
//BFS가 한번 돌때마다 1인 곳을 0으로 -> 이동할 수 있는 칸
public class 벽부수고이동하기4 {
	static int R,C;
	static int trans;
	static int count;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static char[][] map;
	static boolean[][] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Queue<int[]> q;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() {
		q = new LinkedList<int[]>();
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == '1' && !visit[row][col]) {
					q.add(new int[] {row,col});
					visit[row][col] = true;
					BFS();
				}
			}
		}
	}
	private static void BFS() {
		visit = new boolean[R][C];
		trans = 0;
		while(!q.isEmpty()) {
			int size=  q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] == '0' && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							count++;
							trans = count % 10;
							//map[cr][cc] = trans.
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
		visit = new boolean[R][C];
		
		for(int row=0;row<R;row++) {
			String sLine = br.readLine();
			map[row] = sLine.toCharArray();
		}
		view();
	}
	private static void view() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
