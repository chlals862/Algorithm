package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨박꼭질_복습 {
	static boolean flag;
	static int time;
	static int N,K; //N-> 수빈이 위치  | K-> 동생위치
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int[] dr = {1};
	static boolean[] visit = new boolean[100001];
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		q = new LinkedList<Integer>();
		
		q.add(N);
		visit[N] = true;
		BFS();
		bw.write(time+"\n");
		bw.flush();
		bw.close();
	}

	private static void BFS() {
		time = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int current = q.poll();
				if(current == K) {
					return;
				}else {
					int nc = current-1;
					if(rangeCheck(nc) && visit[nc] == false) {
						insertQueue(nc);
					}
					nc = current+1;
					if(rangeCheck(nc) && visit[nc] == false) {
						insertQueue(nc);
					}
					nc = current*2;
					if(rangeCheck(nc) && visit[nc] == false) {
						insertQueue(nc);
					}
				}
			}
			time++;
		}
	}

	private static void insertQueue(int nc) {
		q.add(nc);
		visit[nc] = true;
	}
	private static boolean rangeCheck(int nc) {
		if(nc >= 0 && nc < visit.length) return true;
		return false;
	}
}
