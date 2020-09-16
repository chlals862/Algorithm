package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 미로만들기 {
	static class Node{
		int x, y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static Queue<Node> q;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map, visit;
	static int N; 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
		logic();
	}

	private static void setData() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		visit = new int[N][N];
		map = new int[N][N];
		
		for(int row = 0 ; row < N ; row++) {
			String[] str = br.readLine().split("");
			for(int col = 0 ; col < N ; col++) {
				map[row][col] = Integer.parseInt(str[col]);
				visit[row][col] = Integer.MAX_VALUE; //이동 수 저장할 visit은 무한대 초기화
			}
		}
	}

	private static void logic() throws IOException {
		q.add(new Node(0, 0));
		visit[0][0] = 0;
		bfs();
		bw.write(visit[N-1][N-1]+"\n");
		bw.flush();
		bw.close();
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			Node current = q.poll();

			for(int dir = 0 ; dir < 4 ; ++dir) {
				int nr = current.x + dr[dir];
				int nc = current.y + dc[dir];
				if(nr >= N || nr < 0 || nc >= N || nc < 0) continue;
				
				// 검은 방
				if(map[nr][nc] == 0) {
					if(visit[nr][nc] > visit[current.x][current.y] + 1) {
						visit[nr][nc] = visit[current.x][current.y] + 1;
						q.add(new Node(nr, nc));
					}
				} else {
					if(visit[nr][nc] > visit[current.x][current.y]) {
						visit[nr][nc] = visit[current.x][current.y];
						q.add(new Node(nr, nc));
					}
				}
			}
		}
	}
}
