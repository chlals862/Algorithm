package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PuyoPuyo {
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int count;
	static int chainCnt;
	static boolean chainFlag; //연쇄폭발 유무
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) {
		
		inputData();
		play();
		System.out.println(chainCnt);
		
	}
	private static void play() {
		//언제 끝날지 몰라 
		while(true) {
			explosion();
			if(chainFlag == true) {
				chainCnt++;
				gravity();
			}else break;
		}
	}
	private static void gravity() {
		for(int col=0;col<6;col++) {
			for(int row=11;row>=0;row--) { //밑에서부터 봄
				//중요하대
				if(map[row][col] == '.') {
					int nr = row;
					while(true) {
						nr += dr[0];
						if(rangeCheck(nr,col)) {
							if(map[nr][col] != '.') {
								//올라가다가 알파벳을 만나서 스왑
								map[row][col] = map[nr][col];
								map[nr][col] = '.'; 
								break;
							}
						}else break;
					}
				}
			}
		}
	}
	private static void explosion() {
		chainFlag = false; //초기화
		for(int row=0;row<12;row++) {
			for(int col=0;col<6;col++) {
				if(map[row][col] != '.') {
					count = 1; //초기화
					BFS(row,col,map[row][col]);
					if(count >= 4) {
						bomb();
						//chainCnt++; //연쇄 횟수
						chainFlag = true;
					}
				}
			}
		}
	}
	private static void bomb() {
		for(int row=0;row<12;row++) {
			for(int col=0;col<6;col++) {
				if(visit[row][col] == true) {
					map[row][col] = '.';
				}
			}
		}
		
	}
	private static void BFS(int row, int col, char shape) {
		System.out.println("shape = " + shape);
		q.clear();
		visit = new boolean[12][6]; //새로 쓸거야 
		inserQueue(row,col);

		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				//4방향 조사
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						if(visit[nr][nc] == false && map[nr][nc] == shape) {
							inserQueue(nr, nc);
							count++;
						}
					}
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < 12 && nc >= 0 && nc < 6) return true;
			return false;
	}
	private static void inserQueue(int cr, int cc) {
		q.add(new int[] {cr,cc});
		visit[cr][cc] = true;
	}
	
	private static void inputData() {
		Scanner sc = new Scanner(System.in);
		map = new char[12][6];
		
		for(int row=0;row<12;row++) {
			String sLine = sc.nextLine();
			map[row] = sLine.toCharArray();
		}
		
	}
}
