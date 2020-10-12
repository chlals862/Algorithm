package SW_EXPERT_ACADEMY.모의SW역량테스트;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈주범검거_복습_ing {
	static class Pipe {
		int x;
		int y;
		int type;
		public Pipe(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	static int T,R,C,startR,startC,Time,result,count;
	static int[][] map;
	static boolean[][] visit;
	static Queue<Pipe> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void logic() {
		q.add(new Pipe(startR, startC, map[startR][startC]));
		visit[startR][startC] = true;
		result = 1;
		count++;
		bfs();
		System.out.println(count);
		printMap();
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				Pipe p = q.poll();
				int cr = p.x;
				int cc = p.y;
				p.type = map[cr][cc];
				if(Time == result) return;
				switch(p.type) {
				case 1 :
					type1(p.x,p.y);
				case 2:
					type2(p.x,p.y);				
				case 3:
					type3(p.x,p.y);				
				case 4:
					type4(p.x,p.y);				
				case 5:
					type5(p.x,p.y);				
				case 6:
					type6(p.x,p.y);				
				case 7:
					type7(p.x,p.y);
				}
				//System.out.println("type = " + p.type);
			}
			result++;
		}
	}
	private static void type7(int cr, int cc) {
		if(left(cr,cc));
		if(up(cr,cc));
	}
	private static void type6(int cr, int cc) {
		if(left(cr,cc));
		if(down(cr,cc));
	}
	private static void type5(int cr, int cc) {
		if(down(cr,cc));
		if(right(cr,cc));
	}
	private static void type4(int cr, int cc) {
		if(up(cr,cc));
		if(right(cr,cc));
	}
	private static void type3(int cr, int cc) {
		if(left(cr,cc));
		if(right(cr,cc));
	}
	private static void type2(int cr, int cc) {
		if(up(cr,cc));
		if(down(cr,cc));
	}
	private static void type1(int cr, int cc) {
		if(up(cr,cc));
		if(down(cr,cc));
		if(left(cr,cc));
		if(right(cr,cc));
	}
	private static boolean right(int cr, int cc) {
		if(rangeCheck(cr,cc+1) 
				&& ((map[cr][cc+1] == 1 
				|| map[cr][cc+1] == 3
				|| map[cr][cc+1] == 6
				|| map[cr][cc+1] == 7) 
				&& !visit[cr][cc+1] 
				&& map[cr][cc+1] != 0)) {
			q.add(new Pipe(cr, cc+1, map[cr][cc+1]));
			visit[cr][cc+1] = true;
			count++;
			return true;
		}
		return false;
	}
	private static boolean left(int cr, int cc) {
		if(rangeCheck(cr,cc-1) 
				&& ((map[cr][cc-1] == 1 
				|| map[cr][cc-1] == 3
				|| map[cr][cc-1] == 4
				|| map[cr][cc-1] == 5) 
				&& !visit[cr][cc-1] 
				&& map[cr][cc-1] != 0)) {
			q.add(new Pipe(cr, cc-1, map[cr][cc-1]));
			visit[cr][cc-1] = true;
			count++;
			return true;
		}
		return false;
	}
	private static boolean down(int cr, int cc) {
		if(rangeCheck(cr+1,cc) 
				&& ((map[cr+1][cc] == 1 
				|| map[cr+1][cc] == 2
				|| map[cr+1][cc] == 4
				|| map[cr+1][cc] == 7) 
				&& !visit[cr+1][cc] 
				&& map[cr+1][cc] != 0)){
			q.add(new Pipe(cr+1, cc, map[cr+1][cc]));
			visit[cr+1][cc] = true;
			count++;
			return true;
		}
		return false;
	}
	private static boolean up(int cr, int cc) {
		if(rangeCheck(cr-1,cc) 
				&& ((map[cr-1][cc] == 1 
				|| map[cr-1][cc] == 2 
				|| map[cr-1][cc] == 5 
				|| map[cr-1][cc] == 6) 
				&& !visit[cr-1][cc] 
				&& map[cr-1][cc] != 0)) {
			q.add(new Pipe(cr-1, cc, map[cr-1][cc]));
			visit[cr-1][cc] = true;
			count++;
			return true;
		}
		return false;
	}
	private static boolean rangeCheck(int cr, int cc) {
		if(cr >= 0 && cr < R && cc >= 0 && cc <C) return true;
			return false;
	}
	private static void setData() throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			Time = Integer.parseInt(st.nextToken());
			map = new int[R][C];
			visit = new boolean[R][C];
			q = new LinkedList<Pipe>();
			count = 0;
			for(int row=0;row<R;row++) {
				st = new StringTokenizer(br.readLine());
				for(int col=0;col<C;col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			//printMap();
			logic();
		}
	}
	private static void printMap() {
		for(int row=0;row<R;row++) {
			for(int col=0;col<C;col++) {
				System.out.print(visit[row][col]+ " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
