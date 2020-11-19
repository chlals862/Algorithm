package SW_EXPERT_ACADEMY.D5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 모래성쌓기 {
	static int K,R,C;
	static int[][] map;
	static Queue<int[]> q;
	static int[] dr = {-1,0,1,0,-1,-1,1,1};
	static int[] dc = {0,1,0,-1,-1,1,1,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
	}
	private static void setData() throws NumberFormatException, IOException {
		K = Integer.parseInt(br.readLine());
		for(int k=1;k<=K;k++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			q = new LinkedList<int[]>();
			int result = 0;
			for(int row=0;row<R;row++) {
				String str = br.readLine();
				for(int col=0;col<C;col++) {
					if(str.charAt(col) == '.') map[row][col] = 0;
					else map[row][col] = str.charAt(col)-'0';
					if(map[row][col] == 0) q.add(new int[] {row,col});
				}
			}
			while(!q.isEmpty()) {
				int size = q.size();
				for(int i=0;i<size;i++) {
					int[] currentRC = q.poll();
					int cr = currentRC[0];
					int cc = currentRC[1];
					for(int dir=0;dir<8;dir++) {
						int nr = cr + dr[dir];
						int nc = cc + dc[dir];
						if(rangeCheck(nr,nc)) {
							if(map[nr][nc] > 0 ) {
								map[nr][nc]--;
								if(map[nr][nc] == 0) q.add(new int[] {nr,nc});
							}
						}
					}
				}
				result++;
			}
			bw.write("#"+k+" "+(result-1)+"\n");
		}
		bw.flush();
		bw.close();
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
}
