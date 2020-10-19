package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 미로탈출하기 {
	static int R, C, count;
	static char[][] map;
	static boolean[][] visit;
	// ★★★★★
	static int[][] memo; // 메모이제이션. 0이면 안가본 길 /1이면 성공한 길 /2이면 실패한 길
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		dfsAll();
	}

	private static void dfsAll() throws IOException {
		// 모든 칸에서 시작해보자
		// memo가 0이면 안가본 길
		// memo가 1이면 성공한 길
		// memo가 2이면 실패한 길
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				// 매칸 조사때마다 초기화
				//안가본 길이면
				if(memo[row][col] == 0) memo[row][col] = dfs(row,col);
				//성공한 길이면
				if(memo[row][col] == 1) count++; 
			}
		}
		//printMap();
		bw.write(count + "\n");
		bw.flush();
		bw.close();
	}
	private static int dfs(int cr, int cc) {
		visit[cr][cc] = true;
		int dir = getDirection(cr, cc);
		int nr = cr + dr[dir];
		int nc = cc + dc[dir];
		// 영역을 벗어났다면 탈출
		if (!rangeCheck(nr, nc)) return 1;
		
		//0보다 클때 그 자신을 리턴
		if(memo[nr][nc] >0 ) return memo[nr][nc];

		//방문하지 않았던 곳이면
		if (!visit[nr][nc]) memo[nr][nc] = dfs(nr, nc);
		//위 모든 if줄에 조건에 부합하지 않고 방문한 점이라면
		if(memo[nr][nc] == 1) {
			memo[cr][cc] = 1;
			return 1;
		}else 
			return 2;
	}
	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}
	private static int getDirection(int cr, int cc) {
		int dir = 0;
		switch (map[cr][cc]) {
		// dir0
		case 'U':
			dir = 0;
			break;
		// dir1
		case 'R':
			dir = 1;
			break;
		// dir2
		case 'D':
			dir = 2;
			break;
		// dir3
		case 'L':
			dir = 3;
			break;
		}
		return dir;
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		memo = new int[R][C];
		for (int row = 0; row < R; row++) {
			String str = br.readLine();
			for (int col = 0; col < C; col++) {
				map[row][col] = str.charAt(col);
			}
		}
	}
}
