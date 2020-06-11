package 채찍질;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
	static int R,C;
	static char[][] map;
	static boolean[][] visit;
	static int count;
	//상 우 하 좌 
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static Queue<int[]> q = new LinkedList<int[]>();
	public static void main(String[] args) throws IOException {
		setData();
		BFS();
		printData();
	}
	

	private static void printData() throws IOException {
		bw.write(count+"\n");
		bw.flush();
		bw.close();
	}


	private static void BFS() {
		
		while(!q.isEmpty()) {
			int size = q.size();
			//BFS 돌기전
			System.out.println("size = " + size);
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				
				if(currentRC[0] == R && currentRC[1] == C) {
					return;
				}
				for(int dir=0;dir<4;dir++) {
					int nr = currentRC[0] + dr[dir]; //0에서 dr[-1]을 가는거 
					int nc = currentRC[1] + dc[dir];
					
					if(rangeCheck(nr,nc)) {
						if(map[nr][nc] != '0' && visit[nr][nc] == false) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
		
						}
					}
					
				}
			}
			count++;
		}
		
	}


	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R && nc >= 0 && nc < C) return true;
				return false;
	}


	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visit = new boolean[R][C];
		
		for(int row=0;row<R;row++) {
			String sLine = br.readLine();
			map[row] = sLine.toCharArray();
		}
		//view();
	
		q.add(new int[] {0,0});
		visit[0][0] = true;
		
		
	}

	private static void view() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(map[row][col]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
