package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class 토마토_복습 {
	static StringTokenizer st;
	//static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int M,N;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean[][] visit;
	static boolean flag; //전부다 1인지 아닌지 
	static int count;
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		 M = sc.nextInt();//왜 지역변수로 줬지
		 N = sc.nextInt();
		sc.nextLine();
		map = new int[N][M];
		visit = new boolean[N][M];
		count = 0;
		for(int row = 0; row < N; row++ ) {
			st = new StringTokenizer(sc.nextLine());
			 for(int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());	
			}
		}
		
		//map에서 '1' 조사
		for(int row = 0; row<N; row++) {
			for(int col = 0; col<M; col++) {
				if(map[row][col] == 1 ) {
					//1이 있으면 해당 행,열 q에 저장 
					q.add(new int[] {row,col});
					//해당 행,열 true로
					visit[row][col] = true;
				}
			}
		}
		BFS();
		check();
		check2();	
	}

	private static void check2() {
		if(flag == false) {
			//flag변수가 바뀌지 않았다면 그대로 count를 출력하고
			System.out.println(count-1);
		}else {
			//그렇지 않다면 -1출력<맵에 0이 남아있음>
			System.out.println(-1);
		}
	}

	private static void check() {
		//flag 변수 활용
		for(int row=0;row<N;row++) {
			for(int col=0;col<M;col++) {
				if(map[row][col] == 0) {
					//BFS가 다 끝나도 맵에 0이 남아있다면 flag변수를 활용해 true로 바꿔주고 반복문 빠져나옴
					flag = true;
					break;
				}
			}
			if(flag == true) 
				break;
		}
	}

	private static void BFS() {
		while (!q.isEmpty()) {
			int size = q.size();
			//view();
			for (int i = 0; i < size; i++) {
				int[] current = q.poll();// 1의 row,col
				// 4방향 0이 있는지 조사
				for (int dir = 0; dir < 4; dir++) {
					int nr = current[0] + dr[dir];// -1,0,1,0 차례로 4번조사
					int nc = current[1] + dc[dir];// 0,1,0,-1 차례로 4번조사
					// 4방향의 범위체크
					if (rangeCheck(nr, nc)) {
						//이동할 다음 행,열이 0이고, 방문하지 않았다면
						if (map[nr][nc] == 0 && visit[nr][nc] == false) {
							//그 자리 1로 바꿔주고
							map[nr][nc] = 1;
							//그 자리 q에 저장하고
							q.add(new int[] {nr,nc});
							//방문처리
							visit[nr][nc] = true;
						}
					}
				}
			}
			count++;
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr <= N-1 && nc >=0 && nc <= M-1) {
			return true;
		}
		return false;
	}
	/*
	private static void view() {
		for(int row = 0; row < N; row++) {
			for(int col = 0; col < M; col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}*/
	
}
