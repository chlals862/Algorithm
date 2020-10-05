package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS와DFS {
	static int N,M,V;
	static int[][] map;
	static boolean[] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//정점 수
		M = Integer.parseInt(st.nextToken());//간선 수
		V = Integer.parseInt(st.nextToken());//시작할 정점 번호
		
		map = new int[1001][1001];
		visit = new boolean[1001];
		//간선 연결상태 저장
		for(int row=0;row<M;row++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = map[y][x] = 1;
		}
		dfs(V);
		visit = new boolean[1001];
		bw.write("\n");
		bfs();
		bw.flush();
		bw.close();
	}
	private static void bfs() throws IOException {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(V); //시작점도 q에 넣어야함
		visit[V] = true;
		bw.write(V + " ");
		while(!q.isEmpty()) {
			int cr = q.poll();
			for(int col=1;col<=N;col++) {
				if(map[cr][col] == 1 && !visit[col]) {
					q.add(col);
					visit[col] = true;
					bw.write(col + " ");
				}
			}
		}
	}
	private static void dfs(int V) throws IOException {
		visit[V] = true;
		bw.write(V + " ");
		for(int col=1;col<=N;col++) {
			if(map[V][col] == 1 && !visit[col]) {
				dfs(col);
			}
		}
	}
}
