package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 1
2 3
1 1
1 2
2 2
3 1

2 0 

1
3 6
1 1
1 3
2 2
2 3
3 1
3 2
2 0

0 2
 * */
public class 레이저빔은어디로 {
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int T,N,R,mirrorR,mirrorC,lagerR,lagerC,resR,resC;
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		while(T --> 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[N+2][N+2];
			
			for(int r=0;r<R;r++) {
				st = new StringTokenizer(br.readLine());
				mirrorR = Integer.parseInt(st.nextToken());
				mirrorC = Integer.parseInt(st.nextToken());
				map[mirrorR][mirrorC] = -1;
			}
			
			st = new StringTokenizer(br.readLine());
			lagerR = Integer.parseInt(st.nextToken());
			lagerC = Integer.parseInt(st.nextToken());
			
			for(int row=0;row<map.length;row++) {
				for(int col=0;col<map.length;col++) {
					map[0][col] = -3;
					map[map.length-1][col] = -3;
					map[row][0] = -3;
					map[row][map.length-1] = -3;
				}
			}
			
			if(lagerR == 0) q.add(new int[] {lagerR,lagerC,2}); //아래로
			else if(lagerR == map.length-1) q.add(new int[] {lagerR,lagerC,0}); //위로
			else if(lagerC == 0) q.add(new int[] {lagerR,lagerC,1}); //우측으로
			else if(lagerC == map.length-1) q.add(new int[] {lagerR,lagerC,3}); //좌측으로
			move();
			
			bw.write(resR + " " + resC +"\n");

		} 
		bw.flush();
	}
	private static void move() {
		while(!q.isEmpty()) {

			int[] current = q.poll();
			int dir = current[2];
			int nr = current[0] + dr[dir];
			int nc = current[1]	+ dc[dir];
			 if(isRange(nr,nc)) {
				if(map[nr][nc] == 0) {
					q.add(new int[] {nr,nc,dir});
				}
			}
			switch(dir) {
			case 0 :
				//위로 가다가 거울 만나면 우측으로
				if(map[nr][nc] == -1) q.add(new int[] {nr,nc,1});
				break;
			case 1 :
				//우측으로 가다가 거울 만나면 아래로
				if(map[nr][nc] == -1) q.add(new int[] {nr,nc,2});
				break;
			case 2 :
				//아래로 가다가 거울 만나면 좌측으로
				if(map[nr][nc] == -1) q.add(new int[] {nr,nc,3});
				break;
			case 3 :
				//좌측으로 가다가 거울 만나면 위로
				if(map[nr][nc] == -1) q.add(new int[] {nr,nc,0});
				break;
			}
			if(map[nr][nc] == -3) {
				resR = nr;
				resC = nc;
				break;
			}
		
	}
}
	private static boolean isRange(int nr, int nc) {
		if(nr > 0 && nr < map.length && nc >= 0 && nc < map.length) return true;
			return false;
	}

}
