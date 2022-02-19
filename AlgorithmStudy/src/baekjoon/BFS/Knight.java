package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Knight {
	static int[] dr = {-2,-2,-1,1,2,2,1,-1};
	static int[] dc = {-1,1,2,2,1,-1,-2,-2};
	static boolean[][] visit;
	static boolean flag;
	static int startR,startC,endR,endC,count;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String startRC = br.readLine();
		String endRC = br.readLine();
		visit = new boolean[8][8];
		startR = startRC.charAt(0)-'a';
		startC = startRC.charAt(1)-'1';
		endR = endRC.charAt(0)-'a';
		endC = endRC.charAt(1)-'1';
		visit[startR][startC] = true;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {startR,startC});
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC	= q.poll();
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
			count++;
		}
		bw.write(count+"");
		bw.flush();
		bw.close();
		
	}

}
