package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//육지마다 numbering -> 해당 육지에서 다른 육지가 나온 값들 중에서 최소값 출력하기. 
public class 다리만들기_ing {
	static int N,num;
	static int max = Integer.MAX_VALUE;
	static int[][] inputMap;
	static int[][] bridge;
	static boolean[][] visit;
	static Queue<int[]> q;
	static ArrayList<Integer> list;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		num = 1;
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(inputMap[row][col] == 1 && !visit[row][col]) {
					list = new ArrayList<Integer>();
					inputMap[row][col] = num;
					q.add(new int[] {row,col});
					visit[row][col] = true;
					numbering(num);
					num++;
				}
			}
		}
		//----------------------------------------------------------
		//각 섬마다 번호 부여 끝
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (inputMap[row][col] != 0) q.add(new int[] { row, col });
			}
		}
		visit = new boolean[N][N];
		bridge = new int[N][N];
		BFS();
		for (int result : list) {
			if (max > result) max = result;
		}
		bw.write(max + "\n");
		bw.flush();
		bw.close();
	}
	private static void numbering(int num) {
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
						if(inputMap[nr][nc] == 1 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							inputMap[nr][nc] = num;
						}
					}
				}
			}
		}
	}
	//다리 놓기
	private static void BFS() {
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
						if(inputMap[nr][nc] != 0 
								&& inputMap[cr][cc] != inputMap[nr][nc])
							list.add(bridge[cr][cc]+bridge[nr][nc]);
						if(inputMap[nr][nc] == 0) {
							q.add(new int[] {nr,nc});
							inputMap[nr][nc] = inputMap[cr][cc];
							bridge[nr][nc] = bridge[cr][cc]+1;
							}
						}
					}
				}
			}
		}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		inputMap = new int[N][N];
		visit = new boolean[N][N];
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				inputMap[row][col] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
