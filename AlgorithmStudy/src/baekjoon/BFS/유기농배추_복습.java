package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//2
//10 8 17
//2개의 테스트케이스
//10열 8행 17개
public class 유기농배추_복습 {
	static int area;
	static int T,C,R,K;
	static int KR,KC; //배추의 위치 행열
	static int[][] farm;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {

		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		br.readLine();
		T = Integer.parseInt(st.nextToken()); //TestCase
		
		for(int i=0;i<T;i++) {
			
			C = Integer.parseInt(st.nextToken());//열
			R = Integer.parseInt(st.nextToken());//행
			K = Integer.parseInt(st.nextToken());//배추갯수

			farm = new int[R][C];
			visit = new boolean[R][C];
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for(int j=0;j<K;j++) {
				KR = Integer.parseInt(st.nextToken());//배추 행
				KC = Integer.parseInt(st.nextToken());//배추 열

				farm[KR][KC] = 1;
			}
			
			for(int row=0;row<R;row++) {
				for(int col=0;col<C;col++) {
					if(farm[row][col] == 1 && visit[row][col] == false) {
						q.clear();
						q.add(new int[] {row,col});
						visit[row][col] = true;
						area = 1;

						BFS();
						list.add(area);
					}
				}
			}
			bw.write(list.size()+"\n");
		}//testCase
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
						if(farm[nr][nc] == 1 && visit[nr][nc] == false) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}
		}

	}
	private static boolean rangeCheck(int nr, int nc) {
		if(nr >= 0 && nr < R-1 && nc >= 0 && nc < C-1) return true;
		return false;
	}
}
