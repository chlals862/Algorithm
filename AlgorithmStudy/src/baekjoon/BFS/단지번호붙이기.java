package baekjoon.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 단지번호붙이기 {

	static char[][] map;
	static boolean[][] visitMap;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int housecount;
	
	static int housesize;
	static int mapSize;
	static char num;
	static ArrayList<Integer> answerlist;
	static Queue<int[]> que = new LinkedList<int[]>();
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		mapSize = sc.nextInt();
		
		map = new char[mapSize][mapSize];
		visitMap = new boolean[mapSize][mapSize];
		num='1';
		sc.nextLine();
		housecount = 0;
		housesize = 0;
		answerlist = new  ArrayList<Integer>();
		for(int row=0;row<mapSize;row++) {
				String sLine = sc.nextLine();
				map[row] = sLine.toCharArray();
		}
		
		//view();
		//System.out.println("-------------------------");
		for (int row = 0; row < mapSize; row++) {
			for (int col = 0; col < mapSize; col++) {
				if (map[row][col] == '1' && visitMap[row][col] == false) {
					housecount = 1;
					que.add(new int[] { row, col });
					visitMap[row][col] = true;
					// 여기서BFS돌림
					map[row][col] = num;
					BFS(num);
					answerlist.add(housecount);
					//view();
					num++;
				}
			}
		}
		Collections.sort(answerlist);
		System.out.println(answerlist.size());
		for(Integer number : answerlist) {
			System.out.println(number);
		}
		
	}
	private static void BFS(char num) {
		while(!que.isEmpty()) {
			int size = que.size();
			//System.out.println("BFS 전 ");
			//view();
			for(int i=0;i<size;i++) {
				int[] currentRC = que.poll();
				for(int dir=0;dir<4;dir++) {
					int nr = currentRC[0] + dr[dir];
					int nc = currentRC[1] + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						
						if(map[nr][nc] == '1' && visitMap[nr][nc] == false) {
							que.add(new int[] {nr,nc});
							visitMap[nr][nc] = true;
							map[nr][nc] = num;
							housecount++;
						}
					}
				}
			}
			housesize++;
			//System.out.println("BFS 후");
			//view();
		}	
	}
	
	private static boolean rangeCheck(int nr,int nc) {
		if(nr >= 0 && nr <= mapSize-1 && nc >= 0 && nc <= mapSize-1) {
			return true;
		}
		return false;
	}
//	private static void view() {
//		for(int row=0;row<mapSize;row++) {
//			for(int col=0;col<mapSize;col++) {
//				System.out.print(map[row][col] + "");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		
//	}
}
