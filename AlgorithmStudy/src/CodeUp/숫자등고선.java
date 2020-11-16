package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숫자등고선 {
	static int N,startR,startC,num;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken())-1;
		startC = Integer.parseInt(st.nextToken())-1;
		map = new int[N][N];
		visit = new boolean[N][N];
		num = 1;
		q = new LinkedList<int[]>();
		q.add(new int[] {startR,startC});
		visit[startR][startC] = true;
		map[startR][startC] = num;
		
		while(!q.isEmpty()) {
			int[] dr = {-1,0,1,0};
			int[] dc = {0,1,0,-1};
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(!visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							map[nr][nc] = num+1;
						}
					}
				}
			}
			num++;
		}
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				bw.write(map[row][col]+" ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < N ) return true;
			return false;
	}
}
