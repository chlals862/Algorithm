package SW_EXPERT_ACADEMY.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 파핑파핑지뢰찾기_ing {
	static int K, N,time;
	static boolean flag;
	static char[][] input;
	static int[][] map;
	static int[][] visit;
	static int[] dr = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static Queue<int[]> q;
	static ArrayList<Integer> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		for (int k = 1; k <= K; k++) {
			
			q = new LinkedList<int[]>();
			list = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			input = new char[N][N];
			visit = new int[N][N];
			for (int row = 0; row < N; row++) {
				String str = br.readLine();
				for (int col = 0; col < N; col++) {
					input[row][col] = str.charAt(col);
					if (input[row][col] == '.')
						map[row][col] = 0;
					else if (input[row][col] == '*') {
						map[row][col] = -1;
						visit[row][col] = 1;
					}
				}
			}
			//System.out.println("초기");
			//printMap();
			//0클릭시 8방향 open, 지뢰가 아닌 숫자 클릭시 해당 칸만 open.
			numbering();
			//System.out.println("넘버링 후");
			//printMap();
			//지뢰만 방문된 상황
			int count = 0;
			int time = 0;
			int num = 0;
			for(int row=0;row<N;row++) {
				for(int col=0;col<N;col++) {
					if(map[row][col] == 0) {
						count++;
						if(count == 1) {
							q.add(new int[] {row,col});
							visit[row][col] = 1;
							
							bfs();
							count = 0;
							time++;
							System.out.println("bfs 후");
							printMap2();
							System.out.println("time = " + time);
							
						}
					}
				}
			}
		}
	}

	private static void bfs() {
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
						if(map[nr][nc] == 0 && visit[nr][nc] == 0) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = 1;
						}else if(map[nr][nc] > 0 && visit[nr][nc] == 0) visit[nr][nc] = 1;
					}
				}
			}
		}
		
	}

	private static void numbering() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(map[row][col] == -1) {
					for(int dir=0;dir<8;dir++) {
						int nr = row+dr[dir];
						int nc = col+dc[dir];
						if(rangeCheck(nr,nc)) {
							if(map[nr][nc] != -1) {
								map[nr][nc] += 1;
							}
						}
					}
				}
			}
		}
		
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		return false;
	}

	private static void printMap() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void printMap2() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
