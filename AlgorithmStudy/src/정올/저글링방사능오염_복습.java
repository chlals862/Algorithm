package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 저글링방사능오염_복습 {
	static char[][] map;
	static boolean[][] visit;
	static int time,cnt;
	static int R,C;
	static int pollutionR,pollutionC;
	static Queue<int[]> q;
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
		q = new LinkedList<int[]>();
		q.add(new int[] {pollutionR-1,pollutionC-1});
		map[pollutionR-1][pollutionC-1] = '2';
		visit[pollutionR-1][pollutionC-1] = true;
		BFS();
		count();
		printData();
	}
	private static void count() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == '1') {
					cnt++;
				}
			}
		}
	}
	private static void printData() throws IOException {
		bw.write(time+2+"\n");
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();
	}
	private static void BFS() {
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
						if(map[nr][nc] == '1' && visit[nr][nc] == false) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
							map[nr][nc] = '2';
						}
					}
				}
			}
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
		pollutionC = Integer.parseInt(st.nextToken());
		pollutionR = Integer.parseInt(st.nextToken());
	}
}
