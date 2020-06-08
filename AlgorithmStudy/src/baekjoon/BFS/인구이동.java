package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 인구이동 {
	static int N;
	static int min,max;
	static int count;
	static int sum;
	static int divide;
	static int[][] map;
	static int[][] temp;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() {
		q = new LinkedList<int[]>();
		//전수조사
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				visit = new boolean[N][N];
				temp = new int[N][N];
				insertQueue(row,col);
				BFS();
				}
			}
		}
	private static void BFS() {

		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						int cal = Math.abs(map[cr][cc] - map[nr][nc]);
						//System.out.println("cal="+cal);
						//조건 충족 하는지
						if(cal >= min && cal <= max && visit[nr][nc] == false) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true; //국경선 열기
							temp[nr][nc] = 1;
							sum += map[nr][nc];
							System.out.println("sum = " + sum);
						}
						//조건이 충족하는 곳
						else if(cal >= min && cal <= max && visit[nr][nc] == true && temp[nr][nc] == 1) {
							
						}
					}
				}
			}
			view();
			view3();
			view2();

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
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		temp = new int[N][N];
		visit = new boolean[N][N];
		min = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());

		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		view();
		
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
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void view3() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(temp[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
