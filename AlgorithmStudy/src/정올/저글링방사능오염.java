package 정올;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 // 0 ->빈땅 ,1->저글링
public class 저글링방사능오염 {
	static int time;
	static int count;
	static int R,C;
	static int SR,SC;
	static char[][] map;
	static boolean[][] visit;
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
		insertQueue(SR,SC);
		BFS();
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				if(map[row][col] == '1') {
					count++;
				}
			}
		}
		bw.write(time+2+"\n"+count);
		bw.flush();
		bw.close();
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC  = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] == '1' && visit[nr][nc] == false) {
							insertQueue(nr,nc);
						}
					}
					
				}
			}
			time++;
		}
	}
	private static void insertQueue(int nr, int nc) {
		map[nr][nc] = '2';
		q.add(new int[] {nr,nc});
		visit[nr][nc] = true;
		
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];
		q = new LinkedList<int[]>();
		for(int row=0;row<R;row++) {
			String sLine = br.readLine();
			map[row] = sLine.toCharArray();
		}
		st = new StringTokenizer(br.readLine());
		SC = Integer.parseInt(st.nextToken());
		SR = Integer.parseInt(st.nextToken());
		
	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
}
