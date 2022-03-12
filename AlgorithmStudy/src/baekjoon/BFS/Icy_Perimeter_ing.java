package baekjoon.BFS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Icy_Perimeter_ing {
	static int N,perimeter,maxCnt;
	static char[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static ArrayList<Integer> list2 = new ArrayList<Integer>();
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N+2][N+2];
		visit = new boolean[N+2][N+2];
		for(int row=0;row<N+2;row++) {
			for(int col=0;col<N+2;col++) {
				map[row][0] = map[row][N+1] = '.';
				map[0][col] = map[N+1][col] = '.';
			}
		}
		for(int row=1;row<=N;row++) {
			String temp = br.readLine();
			for(int col=1;col<=N;col++) {
				map[row][col] = temp.charAt(col-1);
			}
		}
		//------------------------------------------------------------
		
		for(int row=0;row<N+2;row++) {
			for(int col=0;col<N+2;col++) {
				if(map[row][col] == '#' && !visit[row][col]) {
					maxCnt = 1;
					perimeter = 0;
					q.add(new int[] {row,col});
					visit[row][col] = true;
					countMax();
					list.add(maxCnt);
					list2.add(perimeter);
				}
			}
		}
		Collections.sort(list, Collections.reverseOrder());
		Collections.sort(list2, Collections.reverseOrder());
		if(list.size() > 0) {
		bw.write(list.get(0) + " " + list2.get(0));
		} else { bw.write(0 + " " + 0); }
		/*
		for(int row=0;row<N+2;row++) {
			for(int col=0;col<N+2;col++) {
				System.out.print(map[row][col]+" ");
			}
			System.out.println();
		}
		*/
		
		bw.flush();
		bw.close();
	}
	private static void countMax() {
		while(!q.isEmpty()) {
			int[] current = q.poll();
			int cr = current[0];
			int cc = current[1];
			for(int dir=0;dir<4;dir++) {
				int nr = cr + dr[dir];
				int nc = cc + dc[dir];
				if(!visit[nr][nc] && map[nr][nc] == '#') {
						q.add(new int[] {nr,nc});
						visit[nr][nc] = true;
						maxCnt++;
				}
				if(map[cr][cc] == '#' && map[nr][nc] == '.') {
					perimeter++;
				}
			}
		}
		
	}

}
