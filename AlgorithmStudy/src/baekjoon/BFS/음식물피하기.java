package baekjoon.BFS;
//3 4 7
//1 1
//1 2
//1 3
//2 1
//2 2
//2 4
//3 4
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 음식물피하기 {
	static int R,C,trash,trashR,trashC,cnt;
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}

	private static void logic() throws IOException {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == 1 && !visit[row][col]) {
					bfs(row,col);
					max = (Math.max(max, cnt) == max ) ? max : cnt;
				}
			}
		}
		bw.write(max-1 + "\n");
		bw.flush();
		bw.close();
	}

	private static void bfs(int row, int col) {
		cnt = 1;
		q.clear();
		q.add(new int[] {row,col});
		while(!q.isEmpty()) {
			
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] == 1 && !visit[nr][nc]) {
							queueAdd(nr,nc);
							cnt++;
						}
					}
				}
			}
			
		}
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >=0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}

	private static void queueAdd(int row, int col) {
		q.add(new int[] {row,col});
		visit[row][col] = true;
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		trash = Integer.parseInt(st.nextToken()); // -> 0
		
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int i=0;i<trash;i++) {
			st = new StringTokenizer(br.readLine());
			trashR = Integer.parseInt(st.nextToken());
			trashC = Integer.parseInt(st.nextToken());
			map[trashR-1][trashC-1] = 1;
		}
	}
}
