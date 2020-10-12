package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 문자들 {
	static int R,C,max;
	static int[][] map;
	static boolean[] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[26];
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				map[row][col] = str.charAt(col) - 'A';
			}
		}
		dfs(0,0,1);
		bw.write(max +"\n");
		bw.flush();
		bw.close();
	}
	private static void dfs(int row, int col, int count) {
		if(max < count) {
			max = count;
		}
		visit[map[row][col]] = true;
		int[] dr = {-1,0,1,0};
		int[] dc = {0,1,0,-1};
		for(int dir=0;dir<4;dir++) {
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(rangeCheck(nr,nc)) {
				if((map[row][col] != map[nr][nc]) && !visit[map[nr][nc]]) {
					visit[map[nr][nc]] = true;
					dfs(nr,nc,count+1);
					visit[map[nr][nc]] = false;
				}
			}
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
}
