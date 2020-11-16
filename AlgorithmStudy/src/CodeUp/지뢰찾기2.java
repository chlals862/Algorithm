package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 지뢰찾기2 {
	static int startR, startC;
	static int[][] map;
	static String[][] result;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		map = new int[10][10];
		visit = new boolean[10][10];
		result = new String[10][10];
		for(int row=1;row<=9;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=1;col<=9;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if(map[row][col] == 1) map[row][col] = -1;
			}
		}
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken());
		startC = Integer.parseInt(st.nextToken());
		q.add(new int[] {startR,startC});
		visit[startR][startC] = true;
		numbering();
		bfs();
		check();
		if(map[startR][startC] > 0) {
			visit = new boolean[10][10];
			result[startR][startC] = Integer.toString(map[startR][startC]);
			visit[startR][startC] = true;
			for(int row=1;row<=9;row++) {
				for(int col=1;col<=9;col++) {
					if(!visit[row][col]) result[row][col] = "_";
				}
			}
			printMap();
		}
		if(map[startR][startC] == 0) {
			printMap();
		}else if(map[startR][startC] == -1) { //첫 시작이 지뢰일 때
			visit = new boolean[10][10];
			visit[startR][startC] = true;
			result[startR][startC] = "-1";
			for(int row=1;row<=9;row++) {
				for(int col=1;col<=9;col++) {
					if(!visit[row][col]) result[row][col] = "_";
				}
			}
			printMap();
		}
	}
	private static void check() {
		for(int row=1;row<=9;row++) {
			for(int col=1;col<=9;col++) {
				result[row][col] = Integer.toString(map[row][col]);
				if(!visit[row][col]) result[row][col] = "_";
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
						if(map[nr][nc] == 0 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						//0이 아닐 경우
						}else if(map[nr][nc] > 0 && !visit[nr][nc]) {
							visit[nr][nc] = true;
						}
					}
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 1 && nr <= 9 && nc >= 1 && nc <=9) return true;
			return false;
	}
	private static void numbering() {
		for(int row=1;row<=9;row++) {
			for(int col=1;col<=9;col++) {
				if(map[row][col] == -1) {
					for(int dir=0;dir<8;dir++) {
						int num = 1;
						int nr = row + dr[dir];
						int nc = col + dc[dir];
						if(rangeCheck(nr,nc)) {
							if(map[nr][nc] != -1) {
								map[nr][nc] += num++;
							}
						}
					}
				}
			}
		}
	}
	private static void printMap() throws IOException {
		for(int row=1;row<=9;row++) {
			for(int col=1;col<=9;col++) {
				bw.write(result[row][col] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
