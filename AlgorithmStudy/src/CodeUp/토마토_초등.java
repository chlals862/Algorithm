package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;
//정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.
public class 토마토_초등 {
	static int R,C,H,time;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0,};
	static int[] dc = {0,1,0,-1};
	static int[] dh = {-1,1};
	static int[][][] box;
	static boolean[][][] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() {
		q = new LinkedList<int[]>();
		for(int h=0;h<H;h++) {
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(box[row][col][h] == 1 && !visit[row][col][h]) {
						q.add(new int[] {row,col,h});
						visit[row][col][h] = true;
					}
				}
			}
		}
		if (!check()) {
			System.out.println(0);
		} else {
			bfs();
		// BFS를 돌고나서도 0인곳이 없으면 -> true
		if (!check()) System.out.println(time-1);
		else System.out.println(-1);
		}
	}
	private static boolean check() {
		for(int h=0;h<H;h++) {
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(box[row][col][h] == 0) return true;
				}
			}
		}
		return false;
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				int ch = currentRC[2];
				//현재 위치에서 4방향
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(box[nr][nc][ch] == 0 && !visit[nr][nc][ch]) {
							box[nr][nc][ch] = 1;
							q.add(new int[] {nr,nc,ch});
							visit[nr][nc][ch] = true;
						}
					}
				}
				//높이 2방향
				for(int hir=0;hir<2;hir++) {
					int nh = ch + dh[hir];
					if(rangeCheck(nh)) {
						if(box[cr][cc][nh] == 0 && !visit[cr][cc][nh]) {
							box[cr][cc][nh] = 1;
							q.add(new int[] {cr,cc,nh});
							visit[cr][cc][nh] = true;
						}
					}
				}
			}
			time++;
		}
	}
	private static boolean rangeCheck(int nh) {
		if(nh >= 0 && nh < H ) return true;
			return false;
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		box = new int[R][C][H];
		visit = new boolean[R][C][H];
		for(int height=0;height<H;height++) {
			for(int row=0;row<R;row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0;col<C;col++) {
					box[row][col][height] = Integer.parseInt(st.nextToken());
				}
			}
		}
		printMap();
	}
	private static void printMap() {
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					System.out.print(box[row][col]+ " ");
				}
				System.out.println();
			}
			System.out.println();
		
		
	}
}
