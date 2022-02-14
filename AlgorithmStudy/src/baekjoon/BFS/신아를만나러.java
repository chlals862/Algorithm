package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 신아를만나러 {
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int startR,startC;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken())+500;
		startC = Integer.parseInt(st.nextToken())+500;
		int N = Integer.parseInt(st.nextToken());
		map = new int[1001][1001];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int stoneR = Integer.parseInt(st.nextToken())+500;
			int stoneC = Integer.parseInt(st.nextToken())+500;
			map[stoneR][stoneC] = -1;
			//map[Integer.parseInt(st.nextToken())+500][Integer.parseInt(st.nextToken())+500] = 1;
		}
		
		
		bw.write(result() + " ");
		bw.flush();
		br.close();
		
	}
	 static int result() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(500, 500, 0));
		map[500][500] = -1;
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.x == startR && n.y == startC) return n.n;
			for(int dir=0;dir<4;dir++) {
				int nr = n.x + dr[dir];
				int nc = n.y + dc[dir];
				if(rangeCheck(nr,nc)) {
					if(map[nr][nc] == 0) {
					q.add(new Node(nr,nc,n.n+1));
					map[nr][nc] = -1;
					}
				}
			}
		}
		return 0;
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < 1001 && nc >= 0 && nc < 1001) return true;
			return false;
	}
	static class Node {
		int x,y,n;

		public Node(int x, int y, int n) {
			this.x = x;
			this.y = y;
			this.n = n;
		}
	}
}
