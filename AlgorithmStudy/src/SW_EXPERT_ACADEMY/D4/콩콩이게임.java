package SW_EXPERT_ACADEMY.D4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 콩콩이게임 {
	static int T,N,K,time;
	static int[] map;
	static boolean[] visit;
	static Queue<Integer> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
    static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
	}
	private static void setData() throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			time = 0;
			q = new LinkedList<Integer>();
			q.clear();
			flag = false;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map  = new int[N];
			visit = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for(int row=0;row<N;row++) {
				map[row] = Integer.parseInt(st.nextToken());
			}
			q.add(0);
			visit[0] = true;
			bfs();
			if(flag) {
				bw.write("#"+t+" "+time+"\n");
			} else bw.write("#"+t+" "+-1+"\n");
		}
		bw.flush();
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int cr = q.poll();
				
				if(cr == N-1) {
					flag = true;
					return;
				} else {
					int nr = cr + 1;
					if(rangeCheck(nr) && map[nr] == 1 && !visit[nr]) {
						q.add(nr);
						visit[nr] = true;
					}
					nr = cr - 1;
					if(rangeCheck(nr) && map[nr] == 1 && !visit[nr]) {
						q.add(nr);
						visit[nr] = true;
					}
					nr = cr + K;
					if(rangeCheck(nr) && map[nr] == 1 && !visit[nr]) {
						q.add(nr);
						visit[nr] = true;
					}
				}
				
			}
			time++;
		}
		
	}
	private static boolean rangeCheck(int nr) {
		if(nr >= 0 && nr < N ) return true;
			return false;
	}
}
