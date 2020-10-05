package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 지뢰찾기2_ing {
	static String ans = "-1";
	static int bomb = 95;
	static char num;
	static int startR, startC;
	static char[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dr = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	private static int time;

	public static void main(String[] args) throws IOException {
		setData();
		System.out.println(ans.toCharArray());
		logic();
	}

	private static void logic() throws IOException {
		
		q = new LinkedList<int[]>();
		if(map[startR][startC] == '1') {
			
		}
		printData();
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (map[row][col] == '1' && !visit[row][col]) {
					map[row][col] = (char) bomb;
				}
			}
		}
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				if (map[row][col] == '0') {
					q.add(new int[] { row, col });
					numbering();
				}
			}
		}
		q.clear();
		visit = new boolean[9][9];
		q.add(new int[] {startR,startC});
		bfs();
		q.clear();
		bfs2();
		
		for(int row=0;row<9;row++) {
			for(int col=0;col<9;col++) {
				if(!visit[row][col]) {
					map[row][col] = '_';
				}
			}
		}
		printData();
	}
	private static void bfs2() {
		for(int row=0;row<9;row++) {
			for(int col=0;col<9;col++) {
				if(visit[row][col]) {
					q.add(new int[] {row,col});
				}
			}
		}
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if(time == 1) return;
				for(int dir=0;dir<8;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(!visit[nr][nc]) {
							visit[nr][nc] = true;
						}
					}
				}
			}
			time++;
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
						if(map[nr][nc] == '0'  && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}
		}	
	}

	private static void numbering() {
		char num = '0';
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for (int dir = 0; dir < 8; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if (rangeCheck(nr, nc)) {
						//현재 위치에서 다음 8방향 위치에 bomb의 수만큼 num++해주고, 현재 위치에 num을 삽입
						if(map[nr][nc] == '_' && !visit[cr][cc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							num++;
							map[cr][cc] = num;
						}
					}
				}
			}
		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < 9 && nc >= 0 && nc < 9)
			return true;
		return false;
	}

	private static void setData() throws IOException {
		map = new char[9][9];
		visit = new boolean[9][9];
		for (int row = 0; row < 9; row++) {
			String sLine = br.readLine().replace(" ", "");
			for (int col = 0; col < 9; col++) {
				map[row][col] = sLine.charAt(col);
			}
		}
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken()) - 1;
		startC = Integer.parseInt(st.nextToken()) - 1;
	}

	private static void printData() throws IOException {
		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {
				bw.write(map[row][col]+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		//bw.close();
	}	
}
