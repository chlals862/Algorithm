package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 계단오르기_ing {
	static int T,result;
	static int[] stair;
	static boolean[] visit;
	static Queue<Integer> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() {
		q.add(0);
		visit[0] = true;
		int cnt = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int cr = q.poll();
				if(visit[cr] == visit[T]) {
					System.out.println("goal");
					return;
				} else {
					int nr = cr + 1;
					if(rangeCheck(nr)) {
						if(!visit[nr] &&  cnt <= 2) {
							q.add(nr);
							visit[nr] = true;
							cnt++;
							result+=stair[nr];
						}
					}
					nr = cr * 2;
					if(rangeCheck(nr)) {
						if(!visit[nr]) {
							q.add(nr);
							visit[nr] = true;
							cnt = 0;
							System.out.println("nr = " + stair[nr]);
							result+=stair[nr];
						}
					}
				}
				
			}
			
			printData();
			System.out.println("result = " + result);
			System.out.println("cnt = " + cnt);
		}
		System.out.println(result);
	}
	private static boolean rangeCheck(int nr) {
		if(nr >= 0 && nr < stair.length) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		stair = new int[T+1];
		visit = new boolean[T+1];
		q = new LinkedList<Integer>();
		stair[0] = 0;
		for(int t=1;t<=T;t++) {
			stair[t] = Integer.parseInt(br.readLine());
		}
		printData2();
	}
	private static void printData() {
		for(int t=0;t<stair.length;t++) {
			System.out.print(visit[t] + " ");
		}
		System.out.println();
		
	}
	private static void printData2() {
		for(int t=0;t<stair.length;t++) {
			System.out.print(stair[t] + " ");
		}
		System.out.println();
		
	}
}
