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
우,아래,대각선 우아래
 * */
public class Bold {
	static int R,C;
	static char[][]	 map;
	static int[] dr = {0,1,1};
	static int[] dc = {1,0,1};
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int row=0;row<R;row++) map[row] = br.readLine().toCharArray();
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == '#') {
					q.add(new int[] {row,col});
				}
			}
		}
		int size = q.size();
		for(int i=0;i<size;i++) {
		int[] currentRC = q.poll();
		int cr = currentRC[0];
		int cc = currentRC[1];
		for(int dir=0;dir<3;dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if(nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if(map[nr][nc] == '.') map[nr][nc] = '#';
			}
		}
	}	
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				bw.write(map[row][col]+"");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
