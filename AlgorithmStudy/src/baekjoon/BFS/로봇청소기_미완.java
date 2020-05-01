package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 로봇청소기_미완 {
	
	static int C,R;
	static char[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int answer,trash;
	static boolean flag;
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		C = sc.nextInt();
		R = sc.nextInt();
		sc.nextLine();
		map = new char[R][C];
		trash = 0;
		for(int row=0;row<R;row++) {
			String sline = sc.nextLine();
			map[row] = sline.toCharArray();
			for(int col=0;col<C;col++) {
				if(map[row][col] == 'o') {
					q.add(new int[] {row,col});
				}
				if(map[row][col] == '*') {
					trash++;
				}
			}
		
		}
		
		BFS();
		if(flag == true) {
			System.out.println(answer);
		}else {
			System.out.println(-1);
		}
	}
	private static void BFS() {
		//1방향으로만 가게
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			System.out.println("BFS전");
			view();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();

				if(trash == 0) {
					answer = time;
					flag = true;
					return;
				}			
				for(int dir=0;dir<4;dir++) {
					int nr = currentRC[0] + dr[dir];
					int nc = currentRC[1] + dc[dir];
					
					if(rangeCheck(nr,nc) && map[nr][nc] != 'x') {
						
						if(map[nr][nc] == '*') {
							map[nr][nc] = '.';
							q.add(new int[] {nr,nc});
							trash--;
							map[nr][nc] = 'n';
						}
						if(map[nr][nc] == '.') {
							q.add(new int[] {nr,nc});
							map[nr][nc] = 's';
						}
					}
				}
			}
			System.out.println("BFS후");
			view();
			time++;
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
			return true;
		}
		return false;
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
