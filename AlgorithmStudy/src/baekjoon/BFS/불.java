package baekjoon.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 불 {
	static int R,C;
	static char[][] maze;
	static boolean[][] jihoonVisit;
	static boolean[][] fireVisit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean flag;
	static int answer;
	static Queue<JF> q = new LinkedList<JF>();
	
	static class JF{//지훈이와 불의 정보
		int jihoonR;
		int jihoonC;
		int fireR;
		int fireC;
		int id;
		public JF(int jihoonR, int jihoonC, int fireR, int fireC, int id) {
			this.jihoonR = jihoonR;
			this.jihoonC = jihoonC;
			this.fireR = fireR;
			this.fireC = fireC;
			this.id = id;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();//행
		C = sc.nextInt();//열
		maze = new char[R][C];
		jihoonVisit = new boolean[R][C];
		fireVisit = new boolean[R][C];
		sc.nextLine();
		ArrayList<JF> tempList = new ArrayList<JF>();
		for(int row=0;row<R;row++) {
			String sLine = sc.nextLine();
			maze[row] = sLine.toCharArray();
			for(int col=0;col<C;col++) {
				if(maze[row][col] == 'J') {
					//큐에 넣을것인가, 리스트에 임시로 넣을것인가
					tempList.add(new JF(row, col, -1, -1, 1));//불의 로우와 행은 일단 아무거나 넣기
					jihoonVisit[row][col] = true;
				}else if(maze[row][col] == 'F') {
					tempList.add(new JF(-1, -1, row, col, 2));
					fireVisit[row][col] = true;
				}
			}
		}
		Collections.sort(tempList,new Comparator<JF>() {
			@Override
			public int compare(JF o1, JF o2) {
				return Integer.compare(o1.id, o2.id);
			}
		});

		for(int i=0;i<tempList.size();i++ ) {
			q.add(tempList.get(i));
		}

		BFS();
		if(flag == true) {
			System.out.println(answer);
		}else {
			System.out.println("IMPOSSIBLE");
		}
	}

	private static void BFS() {
		int time =0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				JF currentJF = q.poll();

				switch (currentJF.id) {
				// 지훈
				case 1:
					if (fireVisit[currentJF.jihoonR][currentJF.jihoonC] == false) {
						moveJihoon(currentJF);
						if (flag == true) {
							time++;
							answer = time;
							return;
						}
					}
					break;

				case 2:
					burn(currentJF);
					break;
				}
			}
			time++;
		}

	}

	private static void burn(JF currentJF) {
		int currentR = currentJF.fireR;
		int currentC = currentJF.fireC;

		for (int dir = 0; dir < 4; dir++) {
			int nr = currentR + dr[dir];
			int nc = currentC + dc[dir];

			if (rangeCheck(nr, nc) && maze[nr][nc] != '#' && fireVisit[nr][nc] == false) {
				q.add(new JF(-1, -1, nr, nc, 2));
				fireVisit[nr][nc] = true;
			}
		}
	}
	private static void moveJihoon(JF currentJF) {
		int currentR = currentJF.jihoonR;
		int currentC  = currentJF.jihoonC;

		for(int dir=0;dir<4;dir++) {
			int nr = currentR + dr[dir];
			int nc = currentC + dc[dir];

			if(rangeCheck(nr,nc) && maze[nr][nc] != 'F' && maze[nr][nc] != '#' && jihoonVisit[nr][nc] == false) {
				q.add(new JF(nr, nc, -1, -1, 1));
				jihoonVisit[nr][nc] = true;
			}else if(rangeCheck(nr,nc) == false){
				flag = true;
				return;
			}
		}
	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr>=0 && nr< R && nc >=0 && nc < C) {
			return true;
		}
		return false;
	}
}
