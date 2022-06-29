package CodeUp.배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1515 {
	static int[][] map;
	static int[][] temp;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,1,1,0,-1,-1};
	static int[] dc = {1,1,1,0,-1,-1,-1,0};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		
		map = new int[25][25];
		temp = new int[25][25];
		for(int row=0;row<25;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<25;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				temp[row][col] = map[row][col];
			}
		}
		
		alive1();
		alive2();
		
		//cons();
		output();
		
		
	}
	private static void output() throws IOException {
		for(int row=0;row<25;row++) {
			for(int col=0;col<25;col++) {
				bw.write(temp[row][col] + " ");
			}
			bw.write("\n");
		}
		bw.write("");
		bw.flush();
		bw.close();
		br.close();
	}
	private static void cons() {
		for(int row=0;row<25;row++) {
			for(int col=0;col<25;col++) {
				if(temp[row][col] == 2) {
					map[row][col] = 1;
				}else if(temp[row][col] == 3) {
					map[row][col] = 0;
				}else if(temp[row][col] == 4) {
					map[row][col] = 1;
				}
			}
		}
		
	}
	private static void alive1() {
		visit = new boolean[25][25];
		
		for(int row=0;row<25;row++) {
			for(int col=0;col<25;col++) {
				if(map[row][col] == 0 && !visit[row][col]) {
					visit[row][col] = true;
					int count = 0;
					
					for(int dir=0;dir<8;dir++) {
						int nr = row+dr[dir];
						int nc = col+dc[dir];
						
						if(rangeCheck(nr,nc)) {
							if(map[nr][nc] == 1) {
								count++;
								if(count == 3) {
									temp[row][col] = 2;
								}else temp[row][col] = 0;
							}
						}
					}
				}
			}
	}
}
	private static void alive2() {
		visit = new boolean[25][25];
		for(int row=0;row<25;row++) {
			for(int col=0;col<25;col++) {
				if(map[row][col] == 1 && !visit[row][col]) {
					visit[row][col] = true;
					int count = 0;
					for(int dir=0;dir<8;dir++) {
						int nr = row+dr[dir];
						int nc = col+dc[dir];
						
						if(rangeCheck(nr,nc)) {
							if(map[nr][nc] == 1) {
								count++;
								if(count == 2 || count == 3) {
									temp[row][col] = 4;
								}
								if(count >= 4 || count <= 1) {
									temp[row][col] = 3;
								}
							}
						}
					}
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		return nr >= 0 && nr < 25 && nc >= 0 && nc < 25;
	}
}
