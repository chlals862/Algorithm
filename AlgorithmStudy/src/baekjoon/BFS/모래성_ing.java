package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 모래성_ing {
	static int R,C;
	static char count;
	static int result;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0,-1,-1,1,1};
	static int[] dc = {0,1,0,-1,-1,1,1,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	static boolean deleteFlag;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
		printData();
	}

	private static void printData() throws IOException {
		bw.write(result);
		bw.flush();
		bw.close();
	}

	private static void logic() {
		while(true) {
			explosion();
			if(deleteFlag) {
				result++;
			}else break;
		}
		
	}

	private static void explosion() {
		deleteFlag = false;
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] != '.' && !visit[row][col]) {
					count ='1';
					System.out.println(map[row][col]);
					bfs(row,col);
					//System.out.println(map[row][col]);
					if(map[row][col] <= count) {
						//System.out.println("delete");
						delete();
						deleteFlag = true;
					}
				}
			}
		}
		
	}

	private static void delete() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(visit[row][col]) {
					map[row][col] = '.';
				}
			}
		}
	}

	private static void bfs(int row, int col) {
		q.clear();
		visit = new boolean[R][C];
		q.add(new int[] {row,col});
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
						if(map[nr][nc] == '.' && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							count++;
						}
					}
				}
			}
			System.out.println("BFS후 count = " + count);
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
		map = new char[R][C];
		visit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = str.charAt(col);
			}
		}
		printMap();
	}

	private static void printMap() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(map[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
