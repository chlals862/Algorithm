package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질4 {
	static int MAX = 100001;
	static int end;
	static boolean[] visit = new boolean[MAX];
	static int[] to = new int[MAX];
	static int[] from = new int[MAX];
	static int[] dr = { -1, 1, 2 };
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static Queue<Integer> q;
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		bfs(start);
	}

	private static void bfs(int start) throws IOException {
		q = new LinkedList<Integer>();
		to[start] = 0;
		visit[start] = true;
		q.add(start);

		while (!q.isEmpty()) {
			int current = q.poll();
			int time = 0;

			for (int dir = 0; dir < 3; dir++) {
				if (dir == 2)
					time = current * dr[dir];
				else
					time = current + dr[dir];

				if (time >= 0 && time < MAX) {
					if (visit[time] == false) {
						q.add(time);
						visit[time] = true;
						to[time] = to[current] + 1;
						from[time] = current;
					}
				}
			}
		}
		bw.write(to[end]+"\n");
		print(start,end);
		bw.flush();
		bw.close();
	}

	private static void print(int start, int end) throws IOException {
		if(start != end) {
			print(start, from[end]);
		}
		bw.write(end+" ");
		
	}
}
