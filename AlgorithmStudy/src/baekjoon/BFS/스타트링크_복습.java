package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 스타트링크_복습 {
	static int cnt;
	static int F,S,G,U,D;
	static boolean[] visit;
	static boolean flag;
	static Queue<Integer> q; 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
		printData();
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int current = q.poll();
				int nu = current + U;
				int nd = current - D;

				if(current == G) {
					flag = true;
					return;
				}
				if(rangeCheck(nu)) {
					if(visit[nu] == false) {
						insertQueue(nu);
					}
				}
				if(rangeCheck(nd)) {
					if(visit[nd] == false) {
						insertQueue(nd);
					}
				}
			}
			cnt++;
		}
	}
	private static void insertQueue(int nu) {
		q.add(nu);
		visit[nu] = true;
	}
	private static boolean rangeCheck(int nu) {
		if(nu >= 1 && nu <= F) return true;
		return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		q = new LinkedList<Integer>();
		visit = new boolean[F+1];
	}
	private static void logic() {
		q.add(S);
		visit[S] = true;
		BFS();
	}
	private static void printData() throws IOException {
		if(flag == true) {
			bw.write(cnt+"\n");
		}else {
			bw.write("use the stairs");
		}
		bw.flush();
		bw.close();
	}
}
