package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gravity {
	static char[][] map;
	static int[] dr = {1};
	static int R,C;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		Queue<int[]> q = new LinkedList<int[]>();
		for(int row=0;row<R;row++) map[row] = br.readLine().toCharArray();
		
		for(int row=R-1;row>=0;row--) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 'o') {
					q.add(new int[] {row,col});
				}
			}
		}
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] CR = q.poll();
				int cr = CR[0];
				int cc = CR[1];
				for(int dir=0;dir<1;dir++) {
					int nr = cr+dr[dir];
					if(nr >= 0 && nr < R) {
						if(map[nr][cc] == '.') {
							map[nr][cc] = 'o';
							map[cr][cc] = '.';
							q.add(new int[] {nr,cc});
						}
					
					}
				}
			}
		}
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				bw.write(map[row][col] + "");
			}
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
