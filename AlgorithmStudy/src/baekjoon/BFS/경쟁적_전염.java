package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
6 16
4 7 8 0 6 16
0 13 0 0 0 12
14 0 0 1 0 3
0 0 9 0 0 15
0 0 5 0 11 0
2 0 0 10 0 0
4 5 4
 * */
public class 경쟁적_전염 {
	static class rank implements Comparable<rank> {
		int r;
		int c;
		int num;
		int second;
		public rank(int r,int c,int num, int second) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.second = second;
		}
		@Override
		public int compareTo(rank o) {
			if(this.num < o.num) {
			return -1; //return -integer.compare과 차이점을 모르겠다.. 결은 같게 나오는데
		}
			return 1; // return integer.compare
	}
}
	static int N,K,S,endR,endC;
	static int[][] map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static boolean flag;
	static ArrayList<rank> virus = new ArrayList<rank>();
	static Queue<rank> q = new LinkedList<rank>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					virus.add(new rank(i, j, map[i][j],0));
				}
			}
		}
			Collections.sort(virus);
			for(int i=0;i<virus.size();i++) q.add(virus.get(i));
			//q = virus;
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			endR = Integer.parseInt(st.nextToken())-1;
			endC = Integer.parseInt(st.nextToken())-1;
			
			BFS();

			bw.write(map[endR][endC]+"\n");
			bw.flush();
			bw.close();
}
	private static void BFS() {
		while(!q.isEmpty()) {
			rank current = q.poll();
			int cr = current.r;
			int cc = current.c;
			int num = current.num;
			int second = current.second;
			if(S == second) break;
			for(int dir=0;dir<4;dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if(map[nr][nc] == 0) {
						q.add(new rank(nr, nc, num,second+1));
						map[nr][nc] = num;
					}
				}
		}
/*
			for(int row=0;row<N;row++) {
				for(int col=0;col<N;col++) {
					System.out.print(map[row][col]+" ");
				}
				System.out.println();
		}*/
			
	}
}
	}

