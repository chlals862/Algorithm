package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class 봄버맨 {
	static int R, C, T;
	static int time;
	static char[][] map;
	static char[][] temp;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
/*
1. 가장 처음에 봄버맨은 일부 칸에 폭탄을 설치해 놓는다. 모든 폭탄이 설치된 시간은 같다.
2.다음 1초 동안 봄버맨은 아무것도 하지 않는다.
3.다음 1초 동안 폭탄이 설치되어 있지 않은 모든 칸에 폭탄을 설치한다. 
    즉, 모든 칸은 폭탄을 가지고 있게 된다. 폭탄은 모두 동시에 설치했다고 가정한다.
4.1초가 지난 후에 3초 전에 설치된 폭탄이 모두 폭발한다.
3과 4를 반복한다.
time이 2의 배수초 일 때마다 모든 폭탄 설치

*/
	private static void con() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 'O') {
					visit[row][col] = true;
				}
			}
		}
	}
	private static void logic() throws IOException {
		visit = new boolean[R][C];
		time = 1;
		con(); 
		System.out.println(time+"초");
		printMap();
		printMap3();
		while(true) {
			if (time == T) break;
			installBomb();//3번
			time++;
			System.out.println("-------------");
			System.out.println(time+"초 폭탄 설치");
			printMap();
			if (time == T) break;
			explosionBomb();
			time++;
			System.out.println("-------------");
			System.out.println(time+"초 폭탄 폭발");
			printMap();
			if (time == T) break;
			installBomb();
			time++;
			System.out.println("-------------");
			System.out.println(time+"초 폭탄 설치");
			printMap();
			if (time == T) break;
			reset();
			time++;
			System.out.println("-------------");
			System.out.println(time+"초 리셋");
			printMap();
			if (time == T) break;

		}
		System.out.println("-------------");
		System.out.println("최종");
		printMap();
	}
	private static void reset() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				map[row][col] = temp[row][col];
			}
		}
	}
	private static void explosionBomb() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(visit[row][col]) {
					bfs(row,col);
				}
			}
		}
	}
	private static void installBomb() {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				if(map[row][col] == '.') map[row][col] = 'O';
			}
		}
	}
	private static void bfs(int cr, int cc) {
		map[cr][cc] = '.';
		for (int dir = 0; dir < 4; dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if (rangeCheck(nr, nc)) {
				map[nr][nc] = '.';
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < R && nc >= 0 && nc < C)
			return true;
		return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		temp = new char[R][C];
		for (int row = 0; row < R; row++) {
			String str = br.readLine();
			for (int col = 0; col < C; col++) {
				map[row][col] = str.charAt(col);
			}
		}
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 'O') {
					temp[row][col] = map[row][col];
				}else temp[row][col] = '.';
			}
		}
		System.out.println("temp");
		printMap2();
	}
	private static void printMap() throws IOException {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				bw.write(map[row][col]+"");
			}
			bw.write("\n");
		}
		bw.flush();
	}
	private static void printMap2() throws IOException {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				bw.write(temp[row][col]+"");
			}
			bw.write("\n");
		}
		bw.flush();
	}
	private static void printMap3() throws IOException {
		for (int row = 0; row < R; row++) {
			for (int col = 0; col < C; col++) {
				bw.write(visit[row][col]+"");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
