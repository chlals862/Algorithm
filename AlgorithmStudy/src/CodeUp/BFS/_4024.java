package CodeUp.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4024 {
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static Queue<int[]> q = new LinkedList<int[]>();
	static char[][] map;
	static boolean[][] visit;
	static int C,R,cnt;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for(int row=0;row<R;row++) {
			String str = br.readLine().replace(" ", "");
			for(int col=0;col<C;col++) {
				map[row][col] = str.charAt(col);
			}
		}
		
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 'L' && !visit[row][col]) {
					int num = 1;
					q.add(new int[] {row,col});
					visit[row][col] = true;
					list.add(num);
					bfs();
				}
			}
		}
		
		bw.write(list.size()+"");
		bw.flush();
		bw.close();
		br.close();
		
	}
	private static void bfs() {
		int[] dr = {-1,0,1,1,1,0,-1,-1};
		int[] dc = {-1,-1,-1,0,1,1,1,0};
		
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int cr = current[0];
			int cc = current[1];
			
			for(int dir=0;dir<8;dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				
				if(isRange(nr,nc)) {
					if(map[nr][nc] == 'L' && !visit[nr][nc]) {
						q.add(new int[] {nr,nc});
						visit[nr][nc] = true;
					}
				}
			}
			//num++;
		}
	}
	private static boolean isRange(int nr, int nc) {
		return nr >= 0 && nr < R && nc >= 0 && nc < C;
	}
}
