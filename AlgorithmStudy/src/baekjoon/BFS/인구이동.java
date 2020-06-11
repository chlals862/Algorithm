package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 
 * 
 * */
public class 인구이동 {
	static int sum,divide,area;
	static int[][] country;
	static boolean[][] visit;
	static int[][] temp;
	static List<Integer> list;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int N;
	static int min,max;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		//BFS();
	}
	/* 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	private static void BFS() {
		//visit = new boolean[N][N];
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				
				//4방향을 조사하는데,min보다 크거나 같고, max보다 작거나 같으면 국경 열기.
				//국경을 개방한 국가들의 인구수는 국경을 열어서 인접한 국가 -> 연합
				//연합의 인구수는 연합에 속한 각 나라의 인구수/나라수(소수점 버림)
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						
						//현재 나라의 인구수와 다음에 이동할 나라의 인구수가 min보다 크거나 같을때
						if(min >= Math.abs(country[cr][cc]-country[nr][nc]) && Math.abs(country[cr][cc]-country[nr][nc]) <= max && visit[nr][nc] == false) {
							//국경열기 -> visit = true 
							System.out.println(Math.abs(country[cr][cc]-country[nr][nc]));
							insertQueue(nr,nc);

						}
					}
					
				}
			}
			//System.out.println("BFS 후");
		//view2();
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
				return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		min = Integer.parseInt(st.nextToken());		
		max = Integer.parseInt(st.nextToken());
		country = new int[N][N];
		visit = new boolean[N][N];
		temp = new int[N][N];
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				country[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		//모든 행,열 조사
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				list = new ArrayList<Integer>();
				insertQueue(row,col);
				BFS();
			}
		}
		view();

	}
	private static void insertQueue(int row, int col) {
		q.add(new int[] {row,col});
		visit[row][col] = true;
		
	}
	private static void view() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(country[row][col]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void view2() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(visit[row][col]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
