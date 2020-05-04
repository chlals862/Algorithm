package baekjoon.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 단지번호붙이기 {
	static int N;
	static char[][] area;
	static boolean[][] visit;
	static int areaCount; //영역의 개수
	static int areaSize; //영역의 크기
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {

		inputData();
		//탐색을 해야될것같은 부분을 다 탐색함
		dfsAll();
		listSorting();
		System.out.println(areaCount);
		for(Integer result : list) {
			System.out.println(result);
		}
	}

	private static void listSorting() {
		Collections.sort(list);
		
	}

	private static void dfsAll() {
		for(int row=0;row<N;row++)  {
			for(int col=0;col<N;col++) {
				if(visit[row][col] == false && area[row][col] == '1') {
					areaCount++;
					areaSize = 0; //새 영역을 구할떄마다 새로운 크기를 구해야하니까
					dfs(row,col);
					list.add(areaSize);
				}
			}
		}

	}

	private static void dfs(int cr, int cc) {
		visit[cr][cc] = true;
		areaSize++;
		for(int dir=0;dir<4;dir++) {
			int nr = cr + dr[dir];
			int nc = cc + dc[dir];
			if(rangeCheck(nr,nc)) {
				if(visit[nr][nc] == false && area[nr][nc] == '1') dfs(nr,nc);
			}
		}

	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;
		return false;
	}

	private static void inputData() {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		area = new char[N][N];
		visit = new boolean[N][N];
		for(int row=0;row<N;row++) {
			String sLine = sc.nextLine();
			area[row] = sLine.toCharArray();
		}

	}
}
