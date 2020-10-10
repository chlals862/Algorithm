package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 단지번호붙이기_DFS {
	static int N,houseCount,areaSize;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static ArrayList<Integer> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		list = new ArrayList<Integer>();
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(map[row][col] == 1 && !visit[row][col]) {
					houseCount++;
					areaSize = 0;
					DFS(row,col);
					list.add(areaSize);
				}
			}
		}
		Collections.sort(list);
		bw.write(list.size()+"\n");
		for(Integer result : list) {
			bw.write(result+"\n");
		}
		bw.flush();
	}
	private static void DFS(int row, int col) {
		areaSize++;
		visit[row][col] = true;
		for(int dir=0;dir<4;dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == 1 && !visit[nr][nc]) {
					DFS(nr,nc);
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];
		for(int row=0;row<N;row++) {
			String[] str = br.readLine().split("");
			for(int col=0;col<N;col++) {
				map[row][col] = Integer.parseInt(str[col]);
			}
		}
	}
}
