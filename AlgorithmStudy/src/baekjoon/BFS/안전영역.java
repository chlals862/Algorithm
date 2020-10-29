package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 안전영역 {
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int maxHeight;
	static int maxArea;
	static int[] dr = {-1,0,1,0};
	static int[] dc=  {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		System.out.println("maxHeight = " + maxHeight);
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				map[row][col] = sc.nextInt();
				if(map[row][col] > maxHeight) {
					maxHeight = map[row][col];
					System.out.println("maxHeight = " + maxHeight);
				}
			}
		}
		rain();
		System.out.println(maxArea);
	}
	private static void rain() {
		//비가 내리는 모든 양의 조사, 비가 내리지 않는 경우도 있음.
		for(int rainfall=0;rainfall<maxHeight;rainfall++) {
			
			bfsAll(rainfall);
		}
		
	}
	private static void bfsAll(int rainfall) {
		q.clear();
		visit = new boolean[N][N];
		int areaCnt = 0; //영역 수
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(map[row][col] > rainfall && visit[row][col] == false) {
					areaCnt++;
					insertQueue(row,col);
					bfs(rainfall);
				}
			}
		}
		maxArea = Math.max(maxArea, areaCnt);
	}
	private static void bfs(int rainfall) {
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i=0;i<size;i++) {
				int[] currentArea = q.poll();
				int cr = currentArea[0];
				int cc = currentArea[1];
				
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] > rainfall && visit[nr][nc] == false) {
							insertQueue(nr, nc);
						}
					}
				}
			}
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
		return false;
	}
	private static void insertQueue(int row, int col) {
		q.add(new int[] {row,col});
		visit[row][col] = true;
		
	}
}
