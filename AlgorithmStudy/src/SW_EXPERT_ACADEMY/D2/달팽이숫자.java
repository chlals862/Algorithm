package SW_EXPERT_ACADEMY.D2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 달팽이숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			boolean[][] visit = new boolean[N][N];
			
			int[] dr = {-1,0,1,0};
			int[] dc = {0,1,0,-1};
			
			int dir = 0;
			int x = 0;
			int y = 0;
			
			for(int i=1;i<=Math.pow(N, 2);i++) {
				map[x][y] = i;
				visit[x][y] = true;
				
				int nr = x + dr[dir];
				int nc = y + dc[dir];
				
				if(nr >= N || nr < 0 || nc >= N || nc < 0 || visit[nr][nc]) {
					dir = (dir+1)%4;
				}
				
				x += dr[dir];
				y += dc[dir];
				
			}
			bw.write("#"+t+"\n");
			for(int row=0;row<N;row++) {
				for(int col=0;col<N;col++) {
					bw.write(map[row][col]+ " ");
				}
				bw.write("\n");
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
