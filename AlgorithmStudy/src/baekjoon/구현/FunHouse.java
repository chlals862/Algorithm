package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FunHouse {
	static int R, C;
	static char[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		while (true) {
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			if (R == 0 && C == 0) break;
			map = new char[R][C];
			
			for (int row = 0; row < R; row++) map[row] = br.readLine().toCharArray();
			st = new StringTokenizer(br.readLine());
			
			for (int row = 0; row < R; row++) {
				for (int col = 0; col < C; col++) {
					if (map[row][col] == '*') {
						if (row == 0) q.add(new int[]{row, col,2}); // 맨 위에서 시작시 아래로
						else if (row == R - 1) q.add(new int[]{row, col,0});// 맨 아래에서 시작시 위로
						else if (col == 0) q.add(new int[]{row, col,1}); // 맨 왼쪽에서 시작시 우측으로
						else if (col == C - 1) q.add(new int[]{row, col,3}); // 맨 우측에서 시작시 좌측으로
					}
				}
			}
			Move();
			bw.write("HOUSE " + ++cnt + "\n");
			for (int row = 0; row < R; row++) {
				for (int col = 0; col < C; col++) {
					bw.write(map[row][col] + "");
				}
				bw.write("\n");
			}

		} // while
		bw.flush();
	}

	private static void Move() {
		while (!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] current = q.poll();
				int dir = current[2];
				int nr = current[0] + dr[dir];
				int nc = current[1] + dc[dir];
				if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if(map[nr][nc] == '.') q.add(new int[] {nr,nc,dir});
				}
				switch(dir) {
				//위로 가면서
				case 0 :
					//우측으로
					if(map[nr][nc] == '/') q.add(new int[] {nr,nc,1});
					//좌측으로
					else if(map[nr][nc] == '\\') q.add(new int[] {nr,nc,3});
					break;
				//우측으로 가면서
				case 1 :
					//위로
					if(map[nr][nc] == '/') q.add(new int[] {nr,nc,0});
					//아래로
					else if(map[nr][nc] == '\\') q.add(new int[] {nr,nc,2});
					break;
				//아래로 가면서
				case 2 :
					//좌측으로
					if(map[nr][nc] == '/') q.add(new int[] {nr,nc,3});
					//우측으로
					else if(map[nr][nc] == '\\') q.add(new int[] {nr,nc,1});
					break;
				//좌측으로 가면서
				case 3 : 
					//아래로
					if(map[nr][nc] == '/') q.add(new int[] {nr,nc,2});
					//위로
					else if(map[nr][nc] == '\\') q.add(new int[] {nr,nc,0});
					break;
				}
					if(map[nr][nc] == 'x') {
						map[nr][nc] = '&';
						break;
					}
			}
		}
	}
}
