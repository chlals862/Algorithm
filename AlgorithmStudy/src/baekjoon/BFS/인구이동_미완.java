package baekjoon.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 인구이동_미완 {
	static int N,L,R,moveCount,nationSize,nationNum;
	static int map[][];
	static int temp[][];
	static boolean visit[][];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	static ArrayList<Integer> tempList;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();//행,열
		L = sc.nextInt();//인접한 국가의 최소값
		R = sc.nextInt();//인정합 국가의 최대값
		
		map = new int[N][N];
		temp = new int[N][N];
		visit = new boolean[N][N];
		moveCount = 0;
		
		
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				map[row][col] = sc.nextInt();		
			}
		}
		nationNum = 1;
		
		view();
		view2();
		view3();
		//System.out.println(nationSize);
		
		while(true) {
			for(int row=0;row<N;row++) {
				for(int col=0;col<N;col++) {
					if(temp[row][col] == 0) {
					q.add(new int[] {row,col});
					visit[row][col] = true;
					temp[row][col] = nationNum;
					BFS();
					nationNum++;
					}
				}
			}
			
			//ㅕ연합앧ㄹ에 대해서 인구배정
			for(int row=0;row<N;row++) {
				for(int col=0;col<N;col++) {
					
				}
			}
		}
	}

	private static void BFS() {
		while(!q.isEmpty()) {
			
			
			System.out.println("BFS 전");
			view();
			view2();
			view3();
			int size = q.size();
			
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int currentRow = currentRC[0];
				int currentCol = currentRC[1];
				//0,0국가가 4방향으로 갈때
				for(int dir=0;dir<4;dir++) {
					int nr = currentRow + dr[dir];
					int nc = currentCol + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						
					}
				}
			}
		}
		System.out.println("BFS 후");
		view();
		view2();
		view3();
		}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr >=0 && nr <= N-1 && nc >= 0 && nc <= N-1 ) {
			return true;
		}
		return false;
	}

	private static void view() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	private static void view2() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(temp[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
	private static void view3() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
}
