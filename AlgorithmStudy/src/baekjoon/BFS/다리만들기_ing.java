package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//육지마다 numbering -> 해당 육지에서 다른 육지가 나온 값들 중에서 최소값 출력하기. 
public class 다리만들기_ing {
	static int N,num,count,min,result;
	static int max = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] temp;
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
	private static void logic() {
		q = new LinkedList<int[]>();
		
		num = 1;
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(map[row][col] == 1 && !visit[row][col]) {
					list = new ArrayList<Integer>();
					map[row][col] = num;
					q.add(new int[] {row,col});
					visit[row][col] = true;
					numbering(num);
					num++;
					//count++;
				}
			}
		}
		visit = new boolean[N][N];
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(map[row][col] > 0 && !visit[row][col]) {
					q.add(new int[] {row,col});
					visit[row][col] = true;
					bfs();
					result = Math.min(max, result);
				}
			}
		}
		System.out.println(max);
	}
	private static void bfs() {
		int count = 0;
		boolean find = false;
		
		loop : while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				int island = map[cr][cc];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] == 0 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							temp[nr][nc] = 1;
						}
						if(map[nr][nc] > 0 && map[nr][nc] != island) {
//							System.out.println("count = " + count);
//							list.add(count);
//							count++;
//							result += 1;
							find = true;
							break loop;
						}
					}
				}
			}
			count+=1; 
			if(find) {
				if(max > count) max = count;
			}
		}
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
						if(map[nr][nc] == 1 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							map[nr][nc] = num;
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
		map = new int[N][N];
		visit = new boolean[N][N];
		temp = new int[N][N];
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			for(int col=0;col<N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		//printMap();
	}
	private static void printMap() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void printMap2() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(temp[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
