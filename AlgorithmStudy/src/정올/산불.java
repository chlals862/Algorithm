package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//일부 칸에 산불이 이미 발생해 있으며 이 산불은 상하좌우로 인접한 빈칸으로 모두 퍼져나갈 수 있다. 
//예산 문제로 인해 방화벽을 3개만 구매하였으며 3개를 모두 세워야 한다.

//이때, 0은 빈 칸, 1은 방화벽, 2는 산불이 발생한 곳이다. 
//아무런 벽을 세우지 않는다면, 산불은 모든 빈 칸으로 퍼져나갈 수 있다.
public class 산불 {
	static int R,C,safeArea;
	static int[][] map;
	static int[][] fire;
	static Queue<int[]> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 0) {
					map[row][col] = 1;
					dfs(1);
					map[row][col] = 0;
				}
			}
		}
		bw.write(safeArea+"");
		bw.flush();
		bw.close();
	}
	private static void dfs(int fireWall) {
		if(fireWall == 3) {
			fireSpread();
		} else {
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(map[row][col] == 0) {
						map[row][col] = 1;
						dfs(fireWall+1);
						map[row][col] = 0;
					}
				}
			}
		}
		int count = 0;
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(fire[row][col] == 0) count++;
			}
		}
		safeArea =  Math.max(safeArea, count);
	}
	private static void fireSpread() {
		q = new LinkedList<int[]>();
		fire = new int[R][C];
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				fire[row][col] = map[row][col];
				if(fire[row][col] == 2) q.add(new int[] {row,col});
			}
		}
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					//불이 없는 곳에 불 발생
					if(rangeCheck(nr,nc)) {
						if(fire[nr][nc] == 0) {
							fire[nr][nc] = 2;
							q.add(new int[] {nr,nc});
						}
					}
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		for(int row=0;row<R;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<C;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
