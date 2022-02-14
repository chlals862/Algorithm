package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 현명한나이트 {
static class Node {
		int x;
		int y;
		int cnt;
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	static int otherR,otherC,N,M;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-2,-2,-1,-1,1,1,2,2};
	static int[] dc = {-1,1,-2,2,-2,2,-1,1};
	static Queue<Node> q = new LinkedList<>();
	static ArrayList<Node> list = new ArrayList<>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int knightR = Integer.parseInt(st.nextToken())-1;
		int knightC = Integer.parseInt(st.nextToken())-1;
		map = new int[N][N];
		visit = new boolean[N][N];
		
		map[knightR][knightC] = 1;
		q.add(new Node(knightR, knightC, 0));
		visit[knightR][knightC] = true;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			otherR = Integer.parseInt(st.nextToken())-1;
			otherC = Integer.parseInt(st.nextToken())-1;
			map[otherR][otherC] = 2;
			list.add(new Node(otherR, otherC, 0));
		}
		
		bfs();
		
		for(int i=0;i<list.size();i++) {
			Node result = list.get(i);
			bw.write(map[result.x][result.y]+ " ");
		}
		bw.write("\n");
		
		//printData();
		bw.flush();
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				Node currentRC = q.poll();
				for(int dir=0;dir<8;dir++) {
					int nr = currentRC.x+dr[dir];
					int nc = currentRC.y+dc[dir];
					if(rangeCheck(nr,nc)) {
						if(!visit[nr][nc]) {
							map[nr][nc] = currentRC.cnt+1;
							visit[nr][nc] = true;
							q.add(new Node(nr, nc, currentRC.cnt+1));
						}
					}
				}
			}
		}
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc  < N) return true;	
		return false;
	}
	private static void printData() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(map[row][col]+" ");
			}
			System.out.println();
		}
		
	}

}
