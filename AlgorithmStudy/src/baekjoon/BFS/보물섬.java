package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 보물섬 {

	static int R;
	static int C;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int answer;//정답을 담을 변수
	static char[][] map;
	static boolean visitMap[][];
	static Queue<int[]> que = new LinkedList<int[]>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		map = new char[R][C];
		visitMap = new boolean[R][C];
		
		for(int row=0;row<R;row++) {
			String sLine = sc.nextLine();
			map[row] = sLine.toCharArray();
		}
		bfsAll();
		System.out.println(answer-1);
	}
	private static void bfsAll() {
		
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				
				if(map[row][col] == 'L') {
					visitMap = new boolean[R][C];
					//que.clear();
					insertQueue(row,col);
					BFS();
				}
			}
		}
		
		
	}
	private static void BFS() {
		int dist=0;
		while(!que.isEmpty()) {
			int size = que.size();
			dist++;
			for(int i=0;i<size;i++) {
				int[] currentRC = que.poll();
				
				for(int dir=0; dir<4; dir++) {
					int nr = currentRC[0] + dr[dir];
					int nc = currentRC[1] + dc[dir];
					
					if(rangeCheck(nr,nc) && visitMap[nr][nc] == false && map[nr][nc] == 'L') {
						insertQueue(nr, nc);
					}
				}
			}
		}
		answer = Math.max(dist,answer);
	}
	
	private static void insertQueue(int row, int col) {
		que.add(new int[] {row,col});
		visitMap[row][col] = true;
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr <= R-1 && nc >= 0 && nc <= C-1) {
			return true;
		}
		return false;
	}
}
