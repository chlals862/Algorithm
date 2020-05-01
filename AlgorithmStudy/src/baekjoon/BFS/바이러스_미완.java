package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 바이러스_미완 {
	static int[][] map;
	static boolean[] visit;
	static int size, num, count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		size = sc.nextInt();
		num = sc.nextInt();

		map = new int[size + 1][size + 1];
		visit = new boolean[size + 1];

		for (int i = 0; i < num; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map[a][b] = map[b][a] = 1;
		}
		BFS(1);
		System.out.println(count);
	}

	private static void BFS(int x) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		while (!q.isEmpty()) {
			x = (int) q.poll();
			visit[x] = true;

			for (int i = 1; i < size; i++) {
				if (visit[i] == false && map[x][i] == 1) {
					visit[i] = true;
					q.add(i);
					count++;
				}
			}
		}
	}
}
