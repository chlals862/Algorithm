package baekjoon.BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 아기상어 {
	static int N;
	static int[][] aquarium;
	static BabyShark babyShark;
	static boolean visit[][];
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<BabyShark> q = new LinkedList<BabyShark>();
	static ArrayList<Fish> catchFishList;
	
	static class Fish {
		int row;
		int col;
		int catchTime;
		public Fish(int row, int col, int catchTime) {
			this.row = row;
			this.col = col;
			this.catchTime = catchTime;
		}

	}
	static class BabyShark {
		int row;
		int col;
		int eat;
		int size;
		int time;

		public BabyShark(int row, int col, int eat, int size, int time) {
			this.row = row;
			this.col = col;
			this.eat = eat;
			this.size = size;
			this.time = time;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		aquarium = new int[N][N];

		for (int row = 0; row < N; row++) {

			for (int col = 0; col < N; col++) {
				aquarium[row][col] = sc.nextInt();

				if (aquarium[row][col] == 9) {
					babyShark = new BabyShark(row, col, 0, 2, 0);
				}
			}
		}
		simulation();
		System.out.println(babyShark.time);
	}

	private static void simulation() {
		while(true) {
			int possibleEatMount = aquariumCheck();
			if(possibleEatMount == 0) {
				return;
			}else {
				BFS();
				switch(catchFishList.size()) {
				case 0 ://먹이로 못 가는 경우
					return;
				default : 
					sorting(); //물고기를 문제의 요구대로 정렬
					int catchFishrow = catchFishList.get(0).row;
					int catchFishcol = catchFishList.get(0).col;
					int catchTime = catchFishList.get(0).catchTime;
					aquarium[babyShark.row][babyShark.col] = 0;
					//먹었으니 0으로 초기화
					aquarium[catchFishrow][catchFishcol] = 9;
					babyShark.row = catchFishrow;
					babyShark.col = catchFishcol;
					babyShark.eat++;
					babyShark.time += catchTime;
					break;
				}

				if(babyShark.size == babyShark.eat) {
					babyShark.size++;
					babyShark.eat = 0;
				}
			}
		}
	}
	private static void sorting() {
		Collections.sort(catchFishList, new Comparator<Fish>() {

			@Override
			public int compare(Fish o1, Fish o2) {
				if(o1.catchTime == o2.catchTime) {
					if(o1.row == o2.row) {
						return Integer.compare(o1.col, o2.col);
					}else {
						return Integer.compare(o1.row, o2.row);
					}
				}
				return Integer.compare(o1.catchTime, o2.catchTime);
			}
		});
	}

	private static void BFS() {
		catchFishList = new ArrayList<Fish>();
		visit = new boolean[N][N];
		q.clear();
		insertQueue(babyShark);
		int time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				BabyShark current = q.poll();
				int cr = current.row;
				int cc = current.col;
				int sharksize = current.size;
				for (int dir = 0; dir < 4; dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];

					if(rangeCheck(nr,nc) && visit[nr][nc] == false) {
						if(aquarium[nr][nc]>sharksize) {
							continue;
						}else if(aquarium[nr][nc] == current.size) {
							insertQueue(new BabyShark(nr, nc, 0, sharksize, time+1));
						}else if(aquarium[nr][nc] > 0 && aquarium[nr][nc] < current.size){
							catchFishList.add(new Fish(nr, nc, time+1));
							new BabyShark(nr, nc, 0, sharksize, time+1);
						}else if(aquarium[nr][nc] == 0) {
							insertQueue(new BabyShark(nr, nc, 0, sharksize, time+1));
						}
					}
				}
			}
			time++;
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr <= N-1 && nc >=0 && nc <= N-1) {
			return true;
		}
		return false;
	}

	private static void insertQueue(BabyShark babyShark) {
		q.add(babyShark);
		visit[babyShark.row][babyShark.col] = true;
	}
	//먹을수 있는 물고기가 있는지
	private static int aquariumCheck() {
		int cnt = 0;
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(aquarium[row][col] < babyShark.size && aquarium[row][col] != 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
