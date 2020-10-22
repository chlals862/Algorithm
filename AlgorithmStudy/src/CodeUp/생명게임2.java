package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 생명게임2 {
	static int R,C;
	static int X,Y,Z;
	static int K,time;
	static int[][] map;
	static int[][] visit;
	static int[] dr = {-1,0,1,0,-1,-1,1,1};
	static int[] dc=  {0,1,0,-1,-1,1,1,-1};
	static Queue<int[]> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		while(true) {
			visit = new int[R][C];
			logic1();
			q.clear();
			logic2();
			time++;
			logic3();
			if(time == K) break;
		}
		printMap();
		bw.flush();
		bw.close();
	}
	private static void logic3() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(visit[row][col] == 1) {
					map[row][col] = 1;
				}
				if(visit[row][col] == 2) {
					map[row][col] = 1;
				}
				if(visit[row][col] == 3) {
					map[row][col] = 0;
				}
			}
		}
		
	}
	//visit 1 -> 다음세대에 생명 탄생,
	//visit 2 -> 다음세대에도 생명 유지
	//visit 3 -> 사망
	//Y가 1일 떄 -> 생명이 있는 칸의 주위 8칸에 최소 1명의 이웃이  있어야함
	//Z가 5일 때 -> 생명이 있는 칸의 주위 8칸에 5명이상의 이웃이 있을 시 사망
	private static void logic2() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 1 && visit[row][col] != 1) {
					q.add(new int[] {row,col});
					con2();
				}
			}
		}
		
	}
	private static void con2() {
		int count = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<8;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] == 1) {
							count++;
						}
					}
				}
				//산다
				if(count >= Y && count < Z) {
					visit[cr][cc] = 2;
				}
				//죽는다
				if(count < Y || count >= Z) {
					visit[cr][cc] = 3;
				}
			}
		}	
	}
	//X가 2일 때 -> 생명이 없는 칸의 주위 8칸에 정확히 2마리의 생명이 존재하는 경우 다음 세대에 그 칸에서 생명이 탄생
	private static void logic1() {
		
		q = new LinkedList<int[]>();
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 0) {
					q.add(new int[] {row,col});
					con1();
				}
			}
		}
	}
	private static void con1() {
		int count = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<8;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] == 1) {
							count++;
						}
					}
				}
				//조건 1.
				if(count == X) {
					visit[cr][cc] = 1;
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
	//1 -> 생명 O
	//0 -> 생명 X
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken()); //생명이 태어나기 위한 이웃의 수
		Y = Integer.parseInt(st.nextToken()); //생명이 살기 위해 필요한 최소 이웃 수
		Z = Integer.parseInt(st.nextToken()); //생명이 죽는 최소 이웃수 
		//한 세대가 지난 후에 생명이 있는 경우를 1, 없는 경우를 0으로 출력
		map = new int[R][C];
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
	}
	private static void printMap() throws IOException {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				bw.write(map[row][col]+" ");
			}
			bw.write("\n");
		}
	}
}
