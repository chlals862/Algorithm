package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
4 6
101111
101010
101011
111011

* 1= 이동할 수 있는 칸
* 0= 이동할 수 없는 칸
*칸을 셀 때에는 시작 위치와 도착 위치도 포함 -> 1부터 시작
* 1,1 시작 -> N,M도착
*/
public class 미로탐색_복습 {
	static int N,M; //행,열
	static int cnt;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		sc.nextLine();
		cnt = 1;
		map = new char[N][M];
		visit = new boolean[N][M];
		for(int row=0;row<N;row++) {
			String sLength = sc.nextLine();
			map[row] = sLength.toCharArray();
		}
		
		q.add(new int[] {0,0});
		visit[0][0] = true;
		
		//System.out.println("N = " + N);
		//System.out.println("M = " + M);
		BFS();
		System.out.println(cnt+1);
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			//view();
			
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] current = q.poll();
				//상우하좌 조사
				for(int dir=0;dir<4;dir++) {
					int nr = current[0] + dr[dir];
					int nc = current[1] + dc[dir];
					if(rangeCheck(nr,nc)) {
						
						//map char형식
						if(map[nr][nc] == '1' && visit[nr][nc] == false) {
							if(nr == N-1 && nc == M-1) {
								//System.out.println("N = " + N + " nc = " + nr);
								//System.out.println("M = " + M + " nr = " + nc);
								return;
							}
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}
			cnt++;
		}
		
	}

	private static void view() {
		for(int row=0; row<N; row++) {
			for(int col=0; col<M; col++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr <= N - 1 && nc >= 0 && nc <= M - 1) {
			return true;
		}
		return false;
	}
}
