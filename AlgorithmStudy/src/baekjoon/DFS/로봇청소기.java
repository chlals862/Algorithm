package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 로봇청소기 { // dfs
	static int R, C, cleanCount;
	static int startR, startC, startDir;
	static int[][] map;
	static boolean stop;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
				       //회전방향
	// dir 0 -> 북쪽  ->     3
	// dir 1 -> 동쪽 ->     0
	// dir 2 -> 남쪽 ->     1
	// dir 3 -> 서쪽 ->     2
	private static void logic() throws IOException {
		cleanCount = 1;
		dfs(startR,startC,startDir);
		bw.write(cleanCount + "");
		bw.flush();
	}
	//0,1,2,3 이 북 동 남 서
	//이에 대한 서쪽 방향은 0~3사이에 있는 값에서 -1을 한 값. ex) 가리키는 방향이 북(0)일때 -1를 빼주는것이 아닌 3으로 값 조정
	private static void dfs(int cr, int cc, int dir) {
		map[cr][cc] = 2; //청소한곳은 2
		//현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
		//왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
		int nr,nc;
		for(int i=0;i<4;i++) {
			dir = (dir+3) %4;
			nr = cr + dr[dir];
			nc = cc + dc[dir];
			if(rangeCheck(nr,nc) && map[nr][nc] == 0) { //청소를 하지 않은 칸이면
				cleanCount++; //청소 카운트 증가
				dfs(nr,nc,dir);
				return;
			}
		}
		
		//후진일 경우 -> 4방향의 칸 중 방문할 칸이 없다면
		//후진을 위한 방향 설정
		int back = (dir+2)%4;
		nr = cr + dr[back];
		nc = cc + dc[back];
		if(rangeCheck(nr,nc) && map[nr][nc] != 1) {
			dfs(cr + dr[back], cc + dc[back], dir);
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
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken());
		startC = Integer.parseInt(st.nextToken());
		startDir = Integer.parseInt(st.nextToken());
		for (int row = 0; row < R; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < C; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
