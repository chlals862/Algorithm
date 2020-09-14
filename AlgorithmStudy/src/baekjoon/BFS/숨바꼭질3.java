package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질3 {
	static int S, E;
	static boolean[] visit;
	static int[] arr;
	static Queue<Integer> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}

	private static void logic() throws IOException {
		bfs(S, E);
	}

	private static void bfs(int S, int E) throws IOException {
		q = new LinkedList<Integer>();
		q.add(S);
		visit[S] = true;
		arr[S] = 0;
		while (!q.isEmpty()) {
			int cr = q.poll();
			
			if (cr == E) break;
			if (cr * 2 >= 0 && cr * 2 <= 100000) {
				if (!visit[cr * 2]) {
					arr[cr * 2] = arr[cr];
					visit[cr * 2] = true;
					q.add(cr * 2);
				}
			}
			if (cr - 1 >= 0 && cr - 1 <=100000) {
				if (!visit[cr - 1]) {
					arr[cr - 1] = arr[cr] + 1;
					visit[cr - 1] = true;
					q.add(cr - 1);
				}
			}
			if (cr + 1 >= 0 && cr + 1 <= 100000) {
				if (!visit[cr + 1]) {
					arr[cr + 1] = arr[cr] + 1;
					visit[cr + 1] = true;
					q.add(cr + 1);
				}
			}
			
			
		}
		bw.write(arr[E] + "\n");
		bw.flush();
		bw.close();
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		visit = new boolean[100001];
		arr = new int[100001];

	}
}
