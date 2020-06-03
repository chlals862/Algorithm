package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 상범빌딩_복습2 {
	static int time;
	static int H,R,C;
	static char[][][] building;
	static boolean flag;
	static boolean[][][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] dh = {-1,1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void printData() throws IOException {
		if(flag) {
			bw.write("Escaped in "+time+" minute(s)."+"\n");
		}else {
			bw.write("Trapped!"+"\n");
		}
		bw.flush();
	}
	private static void logic() {
		for(int height=0;height<H;height++) {
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(building[row][col][height] == 'S') {
						insertQueue(row,col,height);
						BFS();
					}
				}
			}
		}
	}
	private static void BFS() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				int ch = currentRC[2];
				if(building[cr][cc][ch] == 'E') {
					flag = true;
					return;
				}
				for(int dir=0;dir<4;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						if(building[nr][nc][ch] != '#' && visit[nr][nc][ch] == false) {
							insertQueue(nr,nc,ch);
						}
					}
				}
				for(int hir=0;hir<2;hir++) {
					int hr = ch + dh[hir];
					if(heightCheck(hr)) {
						if(building[cr][cc][hr] != '#' && visit[cr][cc][hr] == false) {
							insertQueue(cr,cc,hr);
						}
					}
				}
			}
			time++;
		}
	}
	private static void setData() throws IOException {

		while(true) {
			q.clear();
			flag = false;
			time = 0;
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			building = new char[R][C][H];
			visit  = new boolean[R][C][H];

			if(H == 0 && R == 0 && C == 0 ) return;

			for(int height=0;height<H;height++) {
				for(int row=0;row<R;row++) {
					String sLine = br.readLine();
					for(int col=0;col<C;col++) {
						building[row][col][height] = sLine.charAt(col);
					}
				}
				st = new StringTokenizer(br.readLine());
			}
			logic();
			printData();
		}
	}
	private static boolean heightCheck(int hr) {
		if(hr >= 0 && hr < H) return true;
			return false;
	}

	private static void insertQueue(int nr, int nc, int ch) {
		q.add(new int[] {nr,nc,ch});
		visit[nr][nc][ch] = true;
	}

	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
			return false;
	}
}
