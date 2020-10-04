package SW_EXPERT_ACADEMY.D4;

import java.util.Scanner;

public class Ladder1 {
	static int[][] map, dir = { { 0, 1 }, { 0, -1 }, { -1, 0 } }; // 오 왼 위
	static int r, c, answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			map = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					if (map[i][j] == 2) {
						r = i;
						c = j;
					}
				}
			}
			while (true) {
				for (int i = 0; i < 3; i++) {
					int nx = r + dir[i][0];
					int ny = c + dir[i][1];

					if (isInside(nx, ny) && map[nx][ny] == 1) {
						map[nx][ny] = 0;
						r = nx;
						c = ny;
						break;
					}
				}
				if (r == 0) {
					answer = c;
					break;
				}
			}
			System.out.println("#" + tc + " " + (answer));
		}
	}

	public static boolean isInside(int x, int y) {
		return x >= 0 && x < 100 && y >= 0 && y < 100;
	}
}