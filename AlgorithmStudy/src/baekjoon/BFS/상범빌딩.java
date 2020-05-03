package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 상범빌딩 {
	static int H,R,C;
	static char[][][] building;
	static boolean[][][] visit;
	static boolean flag;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] dh = {-1,1};
	static int time;
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			q.clear();
			time = 0;
			flag = false;
			H = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			if(H == 0 & R == 0 && C == 0 ) {
				return;
			}
			sc.nextLine();
			building = new char[R][C][H];
			visit = new boolean[R][C][H];
			//입력
			for(int h = 0; h < H; h++ ) {
				for(int row = 0; row < R; row++ ) {
					//1줄씩
					String sLine = sc.nextLine();
					for(int col=0;col<C;col++) {
						building[row][col][h] = sLine.charAt(col);
					}
				}
				sc.nextLine();
			}
			//==========================================================
			for(int h = 0; h < H; h++ ) {
				for(int row = 0; row < R; row++ ) {
					for(int col=0;col<C;col++) {
						if(building[row][col][h] == 'S') {
							insertQueue(row,col,h);
						}
					}
				}
			}
			BFS();
			if(flag == true) {
				System.out.println("Escaped in "+time+" minute(s).");
			}else {
				System.out.println("Trapped!");
			}
		}
	}
	private static void BFS() {
		time = 0;
		while(!q.isEmpty()) {
			int size = q.size();

			for(int i=0;i<size;i++) {
				int[] current = q.poll();
				int currentR = current[0];
				int currentC = current[1];
				int currentH = current[2];

				if(building[currentR][currentC][currentH] == 'E') {
					flag = true;
					return;
				}
				//4방향
				for(int dir=0;dir<4;dir++) {
					int nr = currentR + dr[dir];
					int nc = currentC + dc[dir];

					if(rangeCheck(nr,nc)) {
						//현재층의 다음칸이 .이고,#이 아니고 방문하지 않은 곳이면
						if(building[nr][nc][currentH] != '#' && visit[nr][nc][currentH] == false) {
							insertQueue(nr, nc, currentH);
						}
					}
				}
				for(int dir=0;dir<2;dir++) {
					int nh = currentH + dh[dir];

					if(rangeCheck(nh)) {
						if(building[currentR][currentC][nh] != '#' && visit[currentR][currentC][nh] == false) {
							insertQueue(currentR, currentC, nh);
						}
					}
				}
			}
			time++;
		}
	}
	//위 또는 아래층 범위 검사
	private static boolean rangeCheck(int nh) {
		if(nh >= 0 && nh < H ) return true;
		return false;
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
		return false;
	}
	private static void insertQueue(int row, int col, int h) {
		q.add(new int[] {row,col,h});
		visit[row][col][h] = true;
	}
	private static void view() {
		for(int h=0;h<H;h++) {
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					System.out.print(building[row][col][h] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}

	}
}
