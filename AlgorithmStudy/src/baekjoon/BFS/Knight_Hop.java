package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Knight_Hop {
	static boolean[][] visit;
	static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static boolean flag;
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
		visit = new boolean[8][8];
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.add(new int[] {startR,startC});
		visit[startR][startC] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if(cr == endR && cc == endC) {
					flag = true;
					break;
				}
				for(int dir=0;dir<8;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(nr >= 0 && nr < 8 && nc >= 0 && nc < 8) {
						q.add(new int[] {nr,nc});
						visit[nr][nc] = true;
					}
				}
			}
			if(flag) break;
			result++;
		}
		bw.write(result+"");
		bw.flush();
		bw.close();

	}
}
