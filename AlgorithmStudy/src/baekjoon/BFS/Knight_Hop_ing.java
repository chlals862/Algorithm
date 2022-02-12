package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Knight_Hop_ing {
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };
	
	static int result,startR,startC,endR,endC;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken())-1;
		startC = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		endR = Integer.parseInt(st.nextToken())-1;
		endC = Integer.parseInt(st.nextToken())-1;
		Queue<int[]> q = new LinkedList<int[]>();
		map = new int[8][8];
		visit = new boolean[8][8];
		map[startR][startC] = 1;
		map[endR][endC] = 2;
		for(int row=0;row<8;row++) {
			for(int col=0;col<8;col++) {
				System.out.print(map[row][col]+" ");
			}
			System.out.println();
		}
		
		q.add(new int[] {startR,startC});
		visit[startR][startC] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc) && !visit[nr][nc]) {
						if(map[nr][nc] == 2) {
							return;
						}
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						
					}
				}
			}
			result++;
		}
		System.out.println(result);
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < 8 && nc >= 0 && nc < 8) return true;	
			return false;
	}

}
