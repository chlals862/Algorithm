package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*U	통나무를 위로 한 칸 옮긴다.
D	통나무를 아래로 한 칸 옮긴다.
L	통나무를 왼쪽으로 한 칸 옮긴다.
R	통나무를 오른쪽으로 한 칸 옮긴다.
T	중심점을 중심으로 90도 회전시킨다.*/
public class 통나무옮기기 {
	static int N;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static char[][] map;
	static int[][] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Queue<int[]> q;
	static List<Integer> list;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(map[row][col] == 'B') {
					//q.add(new int[] {row,col});
					list.add(row);
					visit[row][col] = 2;
					
					System.out.println("row" + row + " col"+col);
				}
			}
		}
		view();
		for(int i=0;i<list.size();i++) {
			System.out.println(list);
		}
		//BFS();

	}
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
					
					if(rangeCheck(nr,nc) && map[nr][nc] != '1') {
						
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
		map = new char[N][N];
		visit = new int[N][N];
		q = new LinkedList<int[]>();
		list = new ArrayList<Integer>();
		for(int row=0;row<N;row++) {
			String sLine = br.readLine();
			map[row] = sLine.toCharArray();
		}
		
	}
	private static void view() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}
}
