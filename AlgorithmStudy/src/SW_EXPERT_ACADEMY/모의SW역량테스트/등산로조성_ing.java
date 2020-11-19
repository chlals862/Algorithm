package SW_EXPERT_ACADEMY.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 등산로조성_ing {
	static int T,N,K,max;
	static int[][] map,memo;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
	}
	private static void setData() throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N]; memo = new int[N][N];
			int tempK = K;
			int maxHeight = 0;
			int max = 0;
			for(int row=0;row<N;row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0;col<N;col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(map[row][col], maxHeight);
					if(map[row][col] == maxHeight) {
						visit = new boolean[N][N];
						K = tempK;
						dfs(row,col,max);
						//System.out.println("max = " + max);
					}
				}
			}
			printMap();
			printVisit();
			System.out.println("K = " + K);
			//System.out.println("max = " + max);
		}
	}
	private static void dfs(int cr, int cc,int length) {
		visit[cr][cc] = true;
		for(int dir=0;dir<4;dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(K > 0) {
					if(map[nr][nc] < map[cr][cc] && !visit[nr][nc]) {
						System.out.println("case 1");
						visit[nr][nc] = true;
						dfs(nr,nc,length+1);
					}else if(map[nr][nc] >= map[cr][cc] && !visit[nr][nc]) {
						System.out.println("case2-1");
						if(map[cr][cc]-K > map[nr][nc]) {
							System.out.println("case2-2");
							map[nr][nc] = map[cr][cc]-K;
							K--;
							dfs(nr,nc,length+1);
						}
						
					}
				}else if(K == 0) {
					if(map[nr][nc] < map[cr][cc] && !visit[nr][nc]) {
						System.out.println("case 3");
						visit[nr][nc] = true;
						dfs(nr,nc,length+1);
					}
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
			return false;
	}
	private static void printMap() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void printVisit() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
