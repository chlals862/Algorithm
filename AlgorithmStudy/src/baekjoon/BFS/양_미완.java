package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 양_미완 {
	static int sheep,wolf;
	static int R,C; //행,열
	static char map[][];
	static boolean visitMap[][];
	static int[] sw;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		visitMap = new boolean[R][C];
		sw = new int[2];
		sc.nextLine();
		for(int row=0;row<R;row++) {
			String sLine = sc.nextLine();
			map[row] = sLine.toCharArray();
			System.out.println(map[row]);
		}
		
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] != '#' && map[row][col] != '.') {
					System.out.println("row = " + row + " col = " + col);
					q.add(new int[] {row,col});
					
					visitMap[row][col] = true;
					BFS();
					if(sw[sheep] > sw[wolf]) {
						sheep += sw[sheep];
					} else {
						wolf += sw[wolf];
					}
				}
			}
		}
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			System.out.println("size = " + size);
			for(int i = 0; i<size;i++) {
				int[] currentRC = q.poll();
				//System.out.println(currentRC[i] + "current");
				for(int dir = 0; dir < 4; dir++) {
					int nr = currentRC[0] + dr[dir];
					int nc = currentRC[1] + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						System.out.println("nr = " + nr + " nc = " + nc);
						if(map[nr][nc] == 'v') {
							System.out.println("vv");
							sw[wolf]++;
							q.add(new int[] {nr,nc});
							visitMap[nr][nc] = true;
						}
						if(map[nr][nc] == 'o') {
							System.out.println("oo");
							sw[sheep]++;
							q.add(new int[] {nr,nc});
							visitMap[nr][nc] = true;
						}
					}
				}
			}
			
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr <= R-1 && nc >= 0 && nc <= C-1) {
			return true;
		}
		return false;
	}
}
