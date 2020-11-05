package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;

public class 마법사상어와파이어볼_ing {
	static int N, M, K, time;
	static int fireR, fireC, weight, speed, direction;
	static int[][] map;
	static int[][] fireCount;
	static int[] dr = { -1, 0, 1, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static Queue<fireBall> q = new LinkedList<fireBall>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static class fireBall {
		int fireR;
		int fireC;
		int weight;
		int speed;
		int direction;

		public fireBall(int fireR, int fireC, int weight, int speed, int direction) {
			this.fireR = fireR;
			this.fireC = fireC;
			this.weight = weight;
			this.speed = speed;
			this.direction = direction;
		}

	}

	public static void main(String[] args) throws IOException {
		setData();
		System.out.println("맵");
		printMap();
		System.out.println("갯수");
		printCount();
	}

	
	private static void logic() {
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				fireBall f = q.poll();
				int cr = f.fireR;
				int cc = f.fireC;
				int dir = getDirection(f.direction);
				System.out.println("dir = " + dir);
				int nr = cr + dr[dir] * speed;
				int nc = cc + dc[dir] * speed;
				map[cr][cc] = 0;
				// 0 2 4 6 -> 0 1 2 3    상 우 하 좌
				// 1 3 5 7 -> 4 5 6 7
				if (rangeCheck(nr, nc)) {
					fireCount[nr][nc] += fireCount[cr][cc];
					map[nr][nc] += weight;
					weight = map[nr][nc];
					fireCount[cr][cc] = 0;
					count = fireCount[nr][nc];
					if(count >= 2) {
						weight = weight/5;
						speed += f.speed+f.speed;
						speed = speed/count;
						
						System.out.println("speed = " + speed);
						System.out.println("weight = " + weight);
						
					}
				}
			}
			time++;
			if(time == K) return;
		}
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		fireCount = new int[N][N];
		time = 0;
		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());
			fireR = Integer.parseInt(st.nextToken()) - 1;
			fireC = Integer.parseInt(st.nextToken()) - 1;
			weight = Integer.parseInt(st.nextToken());
			speed = Integer.parseInt(st.nextToken());
			direction = Integer.parseInt(st.nextToken());
			map[fireR][fireC] = weight;
			fireCount[fireR][fireC] = 1;
			q.add(new fireBall(fireR, fireC, weight, speed, direction));
			logic();
		}

	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		return false;
	}

	// 상 우 하 좌
	// 왼쪽위 오른쪽 위 오른쪽 아래 왼쪽 아래
	// dr = {-1,0,1,0,-1,-1,1,1}; 0 2 4 6 7 1 3 5
	// dc = {0,1,0,-1,-1,1,1,-1}; 0 1 2 3 4 5 6 7
	// 0 2 4 6 -> 0 1 2 3
	// 1 3 5 7 -> 4 5 6 7
	private static int getDirection(int direction) {
		int dir = 0;
		switch (direction) {
		// 상
		case 0:
			dir = 0;
			break;
		// 오른쪽 위
		case 1:
			dir = 5;
			break;
		// 오른쪽
		case 2:
			dir = 1;
			break;
		// 오른쪽 아래
		case 3:
			dir = 6;
			break;
		// 아래
		case 4:
			dir = 2;
			break;
		// 왼쪽 아래
		case 5:
			dir = 7;
			break;
		// 왼쪽
		case 6:
			dir = 3;
			break;
		// 왼쪽 위
		case 7:
			dir = 4;
			break;
		}
		return dir;
	}

	private static void printMap() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	private static void printCount() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(fireCount[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}


}
