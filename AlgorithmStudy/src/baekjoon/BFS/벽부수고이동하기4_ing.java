package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 플러드 필 알고리즘
 * 다차원 배열의 어떤 칸과 연결된 영역을 찾는 알고리즘
 * */
public class 벽부수고이동하기4_ing {
	static int num;
	static int R,C;
	static char[][] group;
	static int[][] temp;
	static int[] size;
	static boolean[][] wall;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1}; 
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
		group = new char[R][C];
		wall = new boolean[R][C];
		temp = new int[R][C];
		
		for(int row=0;row<R;row++) {
			String sLine = br.readLine();
			group[row] = sLine.toCharArray();
		}
		

		num = 1;
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(group[row][col] == '0' && !wall[row][col]) {
					q.add(new int[] {row,col});
					wall[row][col] = true;
					temp[row][col] = num;
					BFS(num);
					num++;
				}
			}
		}
		size = new int[7];
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(group[row][col] != '0') size[group[row][col]]++;
			}
		}
		for(int row=0;row<size.length;row++) {
			System.out.println(size[row]);
		}
		view();
	}
	private static void BFS(int num) {
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
						if(group[nr][nc] == '0' && !wall[nr][nc]) {
							q.add(new int[] {nr,nc});
							wall[nr][nc] = true;
							temp[nr][nc] = num;
						}
					}
				}
			}
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
				return false;
	}
	private static void view() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(temp[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}


}
