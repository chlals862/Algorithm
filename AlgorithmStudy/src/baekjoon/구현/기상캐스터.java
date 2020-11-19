package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 기상캐스터 {
	static int R,C,num;
	static char[][] input;
	static int[][] cloud;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		input = new char[R][C]; cloud = new int[R][C]; visit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			String str = br.readLine();
			for(int col=0;col<C;col++) {
				input[row][col] = str.charAt(col);
				if(input[row][col] == 'c') visit[row][col] = true;
			}
		}
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(visit[row][col]) {
					q.add(new int[] {row,col});
				}
			}
		}
		bfs();
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(!visit[row][col]) cloud[row][col] = -1;
			}
		}
		printMap();
		bw.close();
	}
	private static void bfs() {
		num = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				int nc = cc+1;
				if(rangeCheck(cr,nc)) {
					if(input[cr][nc] == '.' && !visit[cr][nc]) {
						q.add(new int[] {cr,nc});
						cloud[cr][nc] = num;
						visit[cr][nc] = true;
					}
				}
			}
			num++;
		}
	}
	private static void printMap() throws IOException {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				bw.write(cloud[row][col] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
	private static boolean rangeCheck(int cr, int nc) {
		if(nc >= 0 && nc < C) return true;
			return false;
	}
}
