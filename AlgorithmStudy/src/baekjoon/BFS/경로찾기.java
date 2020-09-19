package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 경로찾기 {
	static int N;
	static int[][] map;
	static Queue<Integer> q = new LinkedList<Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
		printData();
	}
	private static void printData() throws IOException {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				bw.write(map[row][col] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	private static void logic() {
		int temp;
		for(int row=0;row<N;row++) { 
			for(int col=0;col<N;col++) { //첫번째 행부터 갈 수 있는 길들
				if(map[row][col] == 1) { //갈 수 있는 길
					q.add(col);
				}
			}
			while(!q.isEmpty()) {
				temp = q.poll();
				bfs(row,temp);
			}
		}
		
	}
	private static void bfs(int row, int temp) { //row - 시작 지점
		map[row][temp] = 1;
		for(int col=0;col<N;col++) {
			if(map[temp][col] == 1 && map[row][col] != 1) {
				q.add(col);
			}
		}
		
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
