package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
2
2 2
OX
OO
3 3
OXO
OXO
OOX
 * */
public class Minion_Walk_ing {
	static int T,R,C;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R][C];
			visit = new boolean[R][C];
			Queue<int[]> q = new LinkedList<int[]>();
			for(int row=0;row<R;row++) {
				String str = br.readLine();
				map[row] = str.toCharArray();
			}
			if(map[0][0] == 'O') {
			q.add(new int[] {0,0});
			map[0][0] = 'M';
			visit[0][0] = true;
			}
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
							if(map[nr][nc] == 'O' && !visit[nr][nc]) {
								q.add(new int[] {nr,nc});
								visit[nr][nc] = true;
								map[nr][nc] = 'M';
							}
						}
					}
				}
				
			}
			System.out.print("Case: "+t+"\n");
			printWall(map);
			
			if(visit[R-1][C-1]) {
				System.out.print("Minions can cross the room");
			}else System.out.print("Minions cannot cross the room");
			q.clear();
		}
	}
	private static void printWall(char[][] map) {
		for(int col=0;col<C;col++) {
			System.out.print("+---");
		}
		System.out.println("+");
		
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				switch(map[row][col]) {
				case 'X' :
					System.out.print("| X "); break;
				case 'O' :
					System.out.print("|   "); break;
				case 'M' :
					System.out.print("| M "); break;
				}
			}
			System.out.println("|");
			
			for(int col=0;col<C;col++) {
				switch(map[row][col]) {
				case 'O' :
				case 'X' :
				case 'M' :
					System.out.print("+---"); break;
				}
			}
			System.out.println("+");
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C )return true;
			return false;
	}


}
