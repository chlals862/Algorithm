package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//X -> 땅 , . -> 바다
public class 지구온난화 {
	static int R,C,count;
	static char[][] map;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 'X') {
					count = 0;
					for(int dir=0;dir<4;dir++) {
						int nr = row + dr[dir];
						int nc = col + dc[dir];
						//지도의 범위를 벗어나는 칸은 모두 바다이다.
						if(!rangeCheck(nr,nc) || map[nr][nc] == '.') count++;
					}//4방향
					//바다에 인접한곳이 3개 이상이면 q에 넣고 
					if(count >= 3) q.add(new int[] {row,col});
				}
			}
		}
		//바다에 인접한곳이 3군데 이상인 곳들을 바다로 바꿔주기
		while(!q.isEmpty()) {
			int[] currentRC = q.poll();
			int cr = currentRC[0];
			int cc = currentRC[1];
			map[cr][cc] = '.';
		}
		int startR = R; int startC = C; int endR = 0; int endC = 0;
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 'X' ) {
					startR = Math.min(startR, row);
					startC = Math.min(startC, col);
					endR = Math.max(endR, row);
					endC = Math.max(endC, col);
				}
			}
		}
		for(int row=startR;row<=endR;row++) {
			for(int col=startC;col<=endC;col++) {
				bw.write(map[row][col]+"");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C)return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = str.charAt(col);
			}
		}
	}
}
