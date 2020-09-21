package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스_ing {
	static int allComputer, netComputer,result;
	static int[][] network;
	static boolean[] visit;
	static Queue<Integer> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());

		allComputer = Integer.parseInt(st.nextToken());
		network = new int[allComputer + 1][allComputer + 1];
		visit = new boolean[allComputer + 1];
		st = new StringTokenizer(br.readLine());
		netComputer = Integer.parseInt(st.nextToken());
		for (int row = 0; row < netComputer; row++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			network[x][y] = network[y][x] = 1;
		}
		visit[1] = true;
		bfs(1);
		bw.write(result+"\n");
		bw.flush();
		bw.close();
	}

	private static void bfs(int x) {
		q = new LinkedList<Integer>();
		q.add(x);
		while (!q.isEmpty()) {
			Integer col = q.poll();
			for (int row = 1; row < allComputer; row++) {
				if (network[row][col] != 1 || network[col][row] != 1) continue;
				if (visit[row]) continue;
				q.add(row);
				visit[row] = true;
				result++;
			}
		}
	}
}
