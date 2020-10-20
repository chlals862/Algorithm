package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MuyoMuyo {
	static int R,K,count;
	static int[][] map;
	static boolean[][] visit;
	static boolean constraint;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	//R -> 행 , 열은 10. K -> K개 이상 일시 explosion
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		while(true) {
			explosion();
			if(constraint) {
				gravity();
			} else break;
		}
		printMap();
		bw.flush();
		bw.close();
	}
	private static void gravity() {
		for(int col=0;col<10;col++) {
			for(int row=R-1; row>=0; row--) {
				if(map[row][col] == 0) {
					int nr = row;
					while(true) {
						nr += dr[0]; //상
						if(rangeCheck(nr,col)) {
							if(map[nr][col] != 0) {
								map[row][col] = map[nr][col];
								map[nr][col] = 0;
								break;
							}
						}else break;
					}
				}
			}
		}
	}
	private static void explosion() {
		constraint = false;
		for(int row=0;row<R;row++) {
			for(int col=0;col<10;col++) {
				if(map[row][col] != 0) {
					count = 1;
					BFS(row,col,map[row][col]);
					if(count >= K) {
						bomb();
						constraint = true;
					}
				}
			}
		}
		
	}
	private static void bomb() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<10;col++) {
				if(visit[row][col]) map[row][col] = 0;
			}
		}
	}
	private static void BFS(int row, int col, int shape) {
		visit = new boolean[R][10];
		q = new LinkedList<int[]>();
		q.add(new int[] {row,col});
		visit[row][col] = true;
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
						if(map[nr][nc] == shape && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							count++;
						}
					}
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < 10) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[R][10];
		for(int row=0;row<R;row++) {
			String[] str =br.readLine().split("");
			for(int col=0;col<10;col++) {
				map[row][col] = Integer.parseInt(str[col]);
			}
		}
	}
	private static void printMap() throws IOException {
		for(int row=0;row<R;row++) {
			for(int col=0;col<10;col++) {
				bw.write(map[row][col]+"");
			}
			bw.write("\n");
		}
	}
}
