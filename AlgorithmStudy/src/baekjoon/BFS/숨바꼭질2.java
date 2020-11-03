package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질2 {
	static int startR, endR, time;
	static int[] map;
	static boolean[] visit;
	static boolean flag;
	static Queue<Integer> q = new PriorityQueue<Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken()) - 1;
		endR = Integer.parseInt(st.nextToken()) - 1;
		map = new int[endR + 1];
		visit = new boolean[endR + 1];
		q.add(startR);
		visit[startR] = true;
		bfs();
		printMap();
		
		if(flag) {
			System.out.println(time);
		}
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cr = q.poll();
				int nr = cr - 1;
				if(cr == endR) {
					System.out.println("goal");
					flag = true;
					return;
				}
				if (rangeCheck(nr)) {
					if (!visit[nr]) {
						q.add(nr);
						visit[nr] = true;
					}
				}
				nr = cr + 1;
				if (rangeCheck(nr)) {
					if (!visit[nr]) {
						q.add(nr);
						visit[nr] = true;
					}
				}
				nr = cr * 2;
				if (rangeCheck(nr)) {
					if (!visit[nr]) {
						q.add(nr);
						visit[nr] = true;
					}
				}
			}
			time++;
		//	System.out.println("time = " + time);
		}
	//	System.out.println("time = " + time);
		//bw.write(time + "");
		//bw.flush();
	//	bw.close();
		
	}

	private static boolean rangeCheck(int nr) {
		if (nr >= 0 && nr < map.length)
			return true;
		return false;
	}

	private static void printMap() {
		for (int row = 0; row < map.length; row++) {
			System.out.print(map[row] + " ");
		}
		System.out.println();

	}

}
