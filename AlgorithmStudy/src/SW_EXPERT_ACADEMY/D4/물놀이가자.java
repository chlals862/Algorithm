package SW_EXPERT_ACADEMY.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
3
2 3
WLL
LLL
3 2
WL
LL
LW
4 5
LLLWW
WWLLL
LLLWL
LWLLL
*/
public class 물놀이가자 {
	static int N,R,C;
	static int[][] map,memo;
	static boolean[][] visit;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
	}
	private static void setData() throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int k=1;k<=N;k++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			visit = new boolean[R][C]; memo = new int[R][C];
			q = new LinkedList<int[]>();
			for(int row=0;row<R;row++) {
				String str = br.readLine();
				for(int col=0;col<C;col++) {
					if(str.charAt(col) == 'W') memo[row][col] = -1;
				}
			}
			int result = 0;
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(memo[row][col] == -1 ) {
						q.add(new int[] {row,col});
					}
				}
			}
			BFS();
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(memo[row][col] != -1) result += memo[row][col];
				}
			}
			bw.write("#"+k+" "+result+"\n");
			bw.flush();
		}
		bw.close();
	}
	private static void BFS() {
		int num = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(memo[nr][nc] == 0) {
							q.add(new int[] {nr,nc});
							memo[nr][nc] += num;
						}
					}
				}
			}
			num++;
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
}