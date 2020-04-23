package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 토마토 {
	static int N,M;
	static int count;
	static boolean[][] visitMap;
	static int[][] map;
	static boolean flag;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	static StringTokenizer st;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();//렬
		N = sc.nextInt();//행

		map = new int[N][M];
		visitMap = new boolean[N][M];
		count = 0;
		sc.nextLine();
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(sc.nextLine());
			for(int col=0;col<M;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		//전체에서 1의 위치 확인
		for(int row=0;row<N;row++) {
			for(int col=0;col<M;col++) {
				if(map[row][col] == 1) {
					q.add(new int[] {row,col});
					visitMap[row][col] = true;
				}
			}
		}
		bfs();
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {			
				if(map[row][col] == 0) {
					flag = true;
					break;
				}
			}
			if(flag == true) {
				break;
			}
		}
		if(flag == false) {
			System.out.println(count-1);
		}else if(flag == true) {
			System.out.println(-1);
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			
			//System.out.println("bfs 돌기전");
			//view();
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				for (int dir = 0; dir < 4; dir++) {
					int nr = currentRC[0] + dr[dir];
					int nc = currentRC[1] + dc[dir];
					if (rangeCheck(nr, nc)) {
						// 0인지false인지 조사
						if (map[nr][nc] == 0 && visitMap[nr][nc] == false) {
							q.add(new int[] {nr,nc});
							map[nr][nc] = 1;
							visitMap[nr][nc] = true;
						}
					}
				}
			}
			count++;
			//System.out.println("bfs 돌고난후");
			//view();
		}
	}

//	private static void view() {
//		for(int row=0;row<N;row++) {
//			for(int col=0;col<M;col++){
//				System.out.print(Map[row][col]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr <= N-1 && nc >= 0 && nc <= M-1) {
			return true;
		}
		return false;
	}
}
