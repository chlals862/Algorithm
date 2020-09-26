package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 지뢰찾기1 {
	static int R,C,cnt;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0,-1,-1,1,1};
	static int[] dc = {0,1,0,-1,-1,1,1,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	private static boolean flag;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		q.add(new int[] {R,C});
		visit[R][C] = true;
		bfs();
		if(flag) {
			bw.write(-1+"\n");
		}else bw.write(cnt+"\n");
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if(map[cr][cc] == 1) {
					flag = true;
					return;
				}
				for(int dir=0;dir<8;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] == 1 && !visit[nr][nc]) {
							cnt++;
						}
					}
				}
			}
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < 9 && nc >= 0 && nc < 9) return true;
			return false;
	}
	private static void setData() throws IOException {
		map = new int[9][9];
		visit = new boolean[9][9];
		for(int row=0;row<9;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<9;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken())-1;
		C = Integer.parseInt(st.nextToken())-1;
	}
}
