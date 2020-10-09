package SW_EXPERT_ACADEMY.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 등산로조성_ing {
	static int T,N,K,maxheight,result;
	static int[][] map;
	static boolean[][][] visit;
	static Queue<int[]> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visit = new boolean[N][N][K];
			q = new LinkedList<int[]>();
			for(int row=0;row<N;row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0;col<N;col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			logic();
		}//case
	}
	private static void logic() {
		int cnt = 0;
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				cnt = Math.max(cnt, map[row][col]);
			}
		}
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(map[row][col] == cnt) {
					q.add(new int[] {row,col,K});
					visit[row][col][K] = true;
				}
			}
		}
		printData();
		
	}
	private static void printData() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
