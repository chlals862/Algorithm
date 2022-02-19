package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Journey_of_A_Knight {
	static int[] dr = {-2,-2,-1,1,2,2,1,-1};
	static int[] dc = {-1,1,2,2,1,-1,-2,-2};
	static boolean[][] visit;
	static int N,M,endR,endC,result;
	static boolean flag;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		endR = Integer.parseInt(st.nextToken())-1;
		endC = Integer.parseInt(st.nextToken())-1;
		visit = new boolean[M][N];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {0,0});
		visit[0][0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if(cr == endR && cc == endC) {
					flag = true;
					break;
				}
				for(int dir=0;dir<8;dir++) {
					int nr = cr + dr[dir];
					int nc = cc + dc[dir];
					if(nr >= 0 && nr < M && nc >= 0 && nc < N) {
						if(!visit[nr][nc]) {
							q.add(new int[] {nr,nc});
							visit[nr][nc] = true;
						}
					}
				}
			}
			if(flag) break;
			result++;
		}

		if(flag) bw.write(result+"\n");
		else bw.write("NEVAR");
		bw.flush();
		bw.close();
	}

}
