package baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇_ing {
	static int R,C,K;
	static int wallR,wallC,robotR,robotC,cd;
	static int[][] map;
	static boolean[][] visit;
	static int[] direction,dr,dc;
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
		System.out.println("최종");
		printMap();
		printMap2();
	}
	//로봇 -> 1      장애물 -> 2
	/*
	 로봇은 사용자가 지정한 방향을 일직선으로 움직인다.
	이동 중 벽이나 방문한 지역, 장애물을 만날 경우 로봇은 사용자가 지정한 다음 방향으로 움직인다.
	사용자가 지정한 다음 방향이 없다면 맨 처음 방향으로 돌아가서 위의 과정을 반복한다.
	로봇이 움직일 수 없을 경우 동작을 멈춘다. 
	 
	
	 */
	private static void logic() {
		//cd = 0;
		//cd -> 0~3
		q.add(new int[] {robotR,robotC});
		map[robotR][robotC] = 1;
		visit[robotR][robotC] = true;
		printMap();
		dfs(robotR,robotC);
	}
	private static void dfs(int cr, int cc) {
		for(int dir=0;dir<4;dir++) {
		int nr = cr + dr[dir];
		int nc = cc + dc[dir];
		
		if(rangeCheck(nr,nc)) {
			if(map[nr][nc] == 0 && !visit[nr][nc]) {
				map[cr][cc] = 0;
				map[nr][nc] = 1;
				visit[nr][nc] = true;
				dfs(nr,nc);
			}
		}
		else if(!rangeCheck(nr,nc) || visit[nr][nc] || map[nr][nc] == 2) {
			cd = (cd+1) % 4;
			System.out.println("nr = " + nr);
			System.out.println("nc = " + nc);
			System.out.println("cd = " + cd);
			System.out.println("방향  =" + dr[cd] + " " + dc[cd]);
			System.out.println("---");
			System.out.println(direction[cd]);
			//dfs(cr,cc);
		}
		}
		printMap();
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;	
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		direction = new int[4];
		dr = new int[4]; dc = new int[4];
		for(int k=0;k<K;k++) {
			st = new StringTokenizer(br.readLine());
			wallR = Integer.parseInt(st.nextToken());
			wallC = Integer.parseInt(st.nextToken());
			map[wallR][wallC] = 2;
		}
		st = new StringTokenizer(br.readLine());
		robotR = Integer.parseInt(st.nextToken());
		robotC = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		/*
		 * direction -> 1 상 -> dr = 0
				 * direction -> 2 하 -> dr = 2
				 * direction -> 3 좌 -> dc = 3
				 * direction -> 4 우 -> dc = 1
				 * dr = {-1,0,1,0}; dc = {0,1,0,-1};
		*/
		for(int row=0;row<direction.length;row++) {
			direction[row] = Integer.parseInt(st.nextToken());
			if(direction[row] == 1) {
				dr[row] = -1; dc[row] = 0;
			}
			else if(direction[row] == 2) {
				dr[row] = 1; dc[row] = 0;
			}
			else if(direction[row] == 3) {
				dr[row] = 0; dc[row] = -1;
			}
			else if(direction[row] == 4) {
				dr[row] = 0; dc[row] = 1;
			}
		}
		System.out.println("dr");
		printdr();
		System.out.println("dc");
		printdc();
		System.out.println("초기");
	}
	private static void printdr() {
		for(int row=0;row<dr.length;row++) {
			System.out.print(dr[row] + " ");
		}
		System.out.println();
	}
	private static void printdc() {
		for(int row=0;row<dc.length;row++) {
			System.out.print(dc[row] + " ");
		}
		System.out.println();
	}
	private static void printMap() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void printMap2() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
