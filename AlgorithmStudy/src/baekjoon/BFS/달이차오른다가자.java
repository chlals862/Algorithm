package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 달이차오른다가자 {

	static int R,C;
	static int answer;
	static boolean flag;
	static char[][] maze;
	static boolean[][][][][][][][] visit;
	static Queue<Minsik> q = new LinkedList<Minsik>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static class Minsik {
		int row;
		int col;
		int move;
		boolean[] keys;

		public Minsik(int row, int col, int move) {
			this.row = row;
			this.col = col;
			this.move = move;
			this.keys = new boolean[6];
		}
		public void setKey(char key) {
			this.keys[key - 'a'] = true;
		}
		public boolean isContain(char key) {
			return this.keys[key-'a'];
		}
		public String getKeyInformation() {
			String keySet = "";
			for(int i=0;i<6;i++) {
				if(keys[i]) {
					keySet += "1";
				}else keySet += "0";
			}
			return keySet;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		maze = new char[R][C];
		visit = new boolean[R][C][2][2][2][2][2][2];
		for(int row=0;row<R;row++) {
			String sLine = sc.nextLine();
			maze[row] = sLine.toCharArray();
			for(int col=0;col<C;col++) {
				
				if(maze[row][col] == '0') {
					maze[row][col] = '.';
					Minsik minsik = new Minsik(row, col, 0);
					insertQueue(minsik);


				}
			}
		}
		BFS();
		if(flag) System.out.println(answer);
		else System.out.println("-1");
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();

			for(int i=0;i<size;i++) {
				Minsik currentMinsik = q.poll();
				if(maze[currentMinsik.row][currentMinsik.col] == '1') {
					answer = currentMinsik.move;
					flag = true;
					return;
				}
				
				for(int dir=0;dir<4;dir++) {
					int nr = currentMinsik.row + dr[dir];
					int nc = currentMinsik.col + dc[dir];

					if(rangeCheck(nr,nc)) {
						if(maze[nr][nc] != '#') {
							if((maze[nr][nc] >= 'a' && maze[nr][nc] <= 'f') || maze[nr][nc] == '.' || maze[nr][nc] == '1') {
								if(visitCheck(nr,nc,currentMinsik)) {
									Minsik nextMinsik = new Minsik(nr,nc,currentMinsik.move+1);
									for(int j=0;j<6;j++) nextMinsik.keys[j] = currentMinsik.keys[j]; //	//열쇠 복사하기
										if(maze[nr][nc] >= 'a' && maze[nr][nc] <= 'f') nextMinsik.setKey(maze[nr][nc]);
										insertQueue(nextMinsik);
									//문이면 
								}
							}
							else if(maze[nr][nc] >= 'A' && maze[nr][nc] <= 'F') {
								char currentDoor = Character.toLowerCase(maze[nr][nc]);
								if(currentMinsik.isContain(currentDoor)) {
									if(visitCheck(nr,nc,currentMinsik)) {
										Minsik nextMinsik = new Minsik(nr,nc,currentMinsik.move+1);
										for(int j=0;j<6;j++) nextMinsik.keys[j] = currentMinsik.keys[j]; //	//열쇠 복사하기
										insertQueue(nextMinsik);
									}
								}
							}
						}
					}
				}
			}
		}
	}
	private static boolean visitCheck(int nr, int nc, Minsik currentMinsik) {
		String currentKeySet = currentMinsik.getKeyInformation();
		if(visit[nr][nc]
				[Character.getNumericValue(currentKeySet.charAt(0))]
				[Character.getNumericValue(currentKeySet.charAt(1))]
				[Character.getNumericValue(currentKeySet.charAt(2))]
				[Character.getNumericValue(currentKeySet.charAt(3))]
				[Character.getNumericValue(currentKeySet.charAt(4))]
				[Character.getNumericValue(currentKeySet.charAt(5))] == false) {
			return true;
		}
		return false;
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
		return false;
	}
	private static void insertQueue(Minsik minsik) {
		String currentKeySet = minsik.getKeyInformation();
		q.add(minsik);
		visit[minsik.row][minsik.col][Character.getNumericValue(currentKeySet.charAt(0))][Character.getNumericValue(currentKeySet.charAt(1))][Character.getNumericValue(currentKeySet.charAt(2))][Character.getNumericValue(currentKeySet.charAt(3))][Character.getNumericValue(currentKeySet.charAt(4))][Character.getNumericValue(currentKeySet.charAt(5))] = true;
	}
}
