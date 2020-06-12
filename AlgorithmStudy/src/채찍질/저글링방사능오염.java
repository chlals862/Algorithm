package 채찍질;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 저글링방사능오염 {
	static int time = 3;
	static int count;
	static int startR,startC;
	static int R,C;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
		printData();
	}
	private static void printData() throws IOException {
		
		
		//남아있는 애들 체크
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == '1') {
					count++;
				}
			}
		}
		
		bw.write(time-1+"\n"+count+"\n");
		
		bw.flush();
		
		
	}
	private static void logic() {
		q.add(new int[] {startR-1,startC-1});
		visit[startR-1][startC-1] = true;
		map[startR-1][startC-1] = '2';

		BFS();

	}
	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {

				int[] currentRC = q.poll();
				int cr = currentRC[0];//5
				int cc = currentRC[1];//3

				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];

					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] == '1' && visit[nr][nc] == false) {
							q.add(new int[] {nr,nc}); 
							visit[nr][nc] = true;
							map[nr][nc] = '2';
						}
					}
				}
			}
			//BFS 돌린 후 
			time++;
		}

	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
		return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visit = new boolean[R][C];
		for(int row=0;row<R;row++) {
			String sLine = br.readLine();
			map[row] = sLine.toCharArray();
		}
		st = new StringTokenizer(br.readLine());

		startC = Integer.parseInt(st.nextToken());
		startR = Integer.parseInt(st.nextToken());
	}
	private static void view() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
