package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 점프_점프 {
	static int T,res;
	static int[] maze;
	static boolean[] visit;
	static boolean flag;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		maze = new int[T];
		visit = new boolean[T];
		st = new StringTokenizer(br.readLine());
		for(int row=0;row<T;row++) {
			maze[row] = Integer.parseInt(st.nextToken());
		}
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		visit[0] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int cc = q.poll();
				if(cc == T - 1) {
					flag = true;
					break;
				}
				int current = maze[cc];
				for(int j=1;j<=current;j++) {
					int nc = cc + j;
					if(nc >= 0 && nc < T && !visit[nc]) {
						q.add(nc);
						visit[nc] = true;
					}
				}
			}
			if(flag) break;
			res++;
		}
		if(flag) bw.write(res+"\n");
		else bw.write(-1+"\n");
		bw.flush();
		bw.close();
	}

}
