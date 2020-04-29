package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 양치기꿍 {
	static int R, C, sheep, wolf;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<int[]> q;
	static Queue<int[]> wolfList;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		R = sc.nextInt(); // 행
		C = sc.nextInt(); // 열
		map = new char[R][C];
		visit = new boolean[R][C];

		sc.nextLine();
		for (int row = 0; row < R; row++) {
			String sLine = sc.nextLine();
			map[row] = sLine.toCharArray();
		}
		// view();
		q = new LinkedList<int[]>();
		wolfList = new LinkedList<int[]>();
		
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				//맵의 늑대들을 발견하면
				if(map[row][col] == 'v') {
					wolf++;
					wolfList.add(new int[] { row, col });
					System.out.println("wolf = " + wolf);
					System.out.println("row = " + row + " col =" + col);
				}
				//맵의 양들을 발견하면
				if(map[row][col] == 'k') {
					sheep++;
					System.out.println("sheep = " + sheep);
					System.out.println("row = " + row + " col =" + col);
				}
			}
		}
		//맵의 늑대 수만큼 
		int size = wolfList.size();
		System.out.println("wolfList.size" + size);
		for(int i=0;i<size;i++) {
			int[] wcurrent = wolfList.poll();
			if(visit[wcurrent[0]][wcurrent[1]] == false) {
				visit[wcurrent[0]][wcurrent[1]] = true;
				q.add(new int[] {wcurrent[0],wcurrent[1]});
				BFS();
			}
		}
		
		System.out.println(sheep + " " + wolf);
	}// main

	private static void BFS() {
			int w=1,s=0;
			
			while (!q.isEmpty()) {
				int[] current = q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = current[0] + dr[dir];
					int nc = current[1] + dc[dir];
					
					if(rangeCheck(nr,nc)) { continue; }
					if(visit[nr][nc] == true || map[nr][nc] == '#') { continue; }
					if(map[nr][nc] == 'k') {
						s++;
					System.out.println("s = " + s);
					}else if(map[nr][nc] == 'v') {
						w++;
						System.out.println("w = " + w);
					}
					
						q.add(new int[] {nr,nc});
						visit[nr][nc] = true;
					
				}
			}
			if(w>=s) sheep -= s;
			else wolf -= w;
	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr < 0 && nr >= R && nc < 0 && nc >=C) {
			return true;
		}return false;
	}

//	private static void view() {
//		for (int row = 0; row < R; row++) {
//			for (int col = 0; col < C; col++) {
//				System.out.print(map[row][col] + "");
//			}
//			System.out.println();
//		}
//		System.out.println();
//
//	}
}
