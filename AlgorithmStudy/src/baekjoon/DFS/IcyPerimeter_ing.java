package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
//'#'로만 되어 있는 제일 큰 영역과 그 영역의 둘레 값 구하기.
//제일 큰 영역이 여러 개이면, 그 중 가장 작은 둘레 값 출력.
public class IcyPerimeter_ing {
	static int maxAreaSize,areaSize,count,minCount;
	static int N;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static char[][] map;
	static boolean[][] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() {
		int maxAreaSize = 0; int minCount = 0;
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(map[row][col] == '#' && !visit[row][col]) {
					areaSize = 0;
					count = 0;
					dfs(row,col);
					if(maxAreaSize < areaSize) {
						maxAreaSize = areaSize;
						minCount = count;
					}else if (maxAreaSize == areaSize && minCount > count) {
						minCount = count;
					}
				}
			}
		}
		System.out.println(maxAreaSize);
		System.out.println(minCount);
	}
	private static void dfs(int cr, int cc) {
		visit[cr][cc] = true;
		areaSize++;
		for(int dir=0;dir<4;dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if(rangeCheck(nr,nc) || map[nr][nc] == '.') {
				System.out.println("??");
				count++;
				continue;
				
			}
			System.out.println("?");
			if(visit[nr][nc]) continue;
			System.out.println("...");
			dfs(nr,nc);
			System.out.println("areaSize = " + areaSize);
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 || nr < N || nc >= 0 || nc < N) return true;	
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		visit = new boolean[N][N];
		for(int row=0;row<N;row++) {
			String str = br.readLine();
			for(int col=0;col<N;col++) {
				map[row][col] = str.charAt(col);
			}
		}
	}
}
