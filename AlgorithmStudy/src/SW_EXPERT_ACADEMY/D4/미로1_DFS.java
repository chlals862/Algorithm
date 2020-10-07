package SW_EXPERT_ACADEMY.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 미로1_DFS {
	static int t;
	static char[][] map;
	//static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	private static boolean flag;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		for(int k=1;k<=10;k++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			flag = false;
			map = new char[16][16];
			//visit = new boolean[16][16];
			for(int row=0;row<16;row++) {
				String str = br.readLine();
				for(int col=0;col<16;col++) {
					map[row][col] = str.charAt(col);
				}
			}
			
			logic(k);
		}//case
		bw.flush();
	}
	private static void logic(int k) throws IOException {
		for(int row=0;row<16;row++) {
			for(int col=0;col<16;col++) {
				if(map[row][col] == '2') {
					dfs(row,col);
				}
			}
		}
		if(flag) {
			bw.write("#"+k+" "+1+"\n");
		}else bw.write("#"+k+" "+0+"\n");
	}
	private static void dfs(int row, int col) {
		if(flag) return;
		map[row][col] = '1';
		for(int dir=0;dir<4;dir++) {
			if(flag) return;
			int nr = row + dr[dir];
			int nc = col + dc[dir];
			if(map[nr][nc] == '3') {
				flag = true;
				return;
			}
			if(rangeCheck(nr,nc)) {
				if(map[nr][nc] == '0') {
					dfs(nr,nc);
				}
			}
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < 16 && nc >= 0 && nc < 16) return true;
			return false;
	}
}
