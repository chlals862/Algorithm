package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연결요소의개수 {
	static int N,M,res;
	static int[][] map;
	static boolean[] visit;
	static Queue<Integer> q = new LinkedList<Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visit = new boolean[N];
		
		for(int row=0;row<M;row++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			map[A-1][B-1] = 1;
			map[B-1][A-1] = 1;
		}
		
		for(int row=0;row<N;row++) {
			if(!visit[row]) {
				bfs(row);
				res++;
			}
		}
		bw.write(res+"\n");
		bw.flush();
	}
	private static void bfs(int row) {
		q.add(row);
		visit[row] = true;
		
		while(!q.isEmpty()) {
			int current = q.poll();
			for(int i=0;i<N;i++) {
				if(map[current][i] == 1 && !visit[i]) {
					q.add(i);
					visit[i] = true;
				}
			}
		}
		
	}

}
