package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스전파_BFS {
	static int N,T,day;
	static int schoolAreaR,schoolAreaC;
	static int virusR,virusC;
	static int[][] city;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0,-1,-1,1,1};
	static int[] dc = {0,1,0,-1,-1,1,1,-1};
	static Queue<int[]> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	private static boolean flag;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		q = new LinkedList<int[]>();
		q.add(new int[] {virusR,virusC});
		visit[virusR][virusC] = true;
		city[virusR][virusC] = 2;
		bfs();
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(city[row][col] == 3 ) {
					flag = true;
				}
			}
		}
		if(flag) {
			bw.write(1+"\n");
		}else bw.write(0+"\n");
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] virusCR = q.poll();
				int vr = virusCR[0];
				int vc = virusCR[1];
				for(int dir=0;dir<4;dir++) {
					int nr = vr + dr[dir];
					int nc = vc + dc[dir];
					if(day == T ) return;
					if(rangeCheck(nr,nc)) {
						if(city[nr][nc] == 0 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							city[nr][nc] = 2;
						}
						if(city[nr][nc] == 1 && !visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							city[nr][nc] = 3;
						}
					}
				}
			}
			day++;
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N) return true;	
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		city = new int[N][N];
		visit = new boolean[N][N];
		st = new StringTokenizer(br.readLine());
		schoolAreaR = Integer.parseInt(st.nextToken())-1;
		schoolAreaC = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		virusR = Integer.parseInt(st.nextToken())-1;
		virusC = Integer.parseInt(st.nextToken())-1;
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		city[schoolAreaR][schoolAreaC] = 1;
		for(int dir=0;dir<8;dir++) {
			
			int nr = schoolAreaR + dr[dir];
			int nc = schoolAreaC + dc[dir];
			if(rangeCheck(nr,nc)) {
			city[nr][nc] = 1;
			}
		}
	}
}
