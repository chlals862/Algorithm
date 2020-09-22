package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 지금만나러갑니다_ing {

	static class dock {
		int oR,uR;
		public dock(int oR, int uR) {
			this.oR = oR;
			this.uR = uR;
		}
	}
	static int time;
	static int[] map;
	static int[] dr = {-1,1};
	static boolean[] oVisit;
	static boolean[] uVisit;
	static boolean flag;
	static int R,startR,endR;
	static Queue<dock> q;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}
	private static void logic() {
		q = new LinkedList<dock>();
		q.add(new dock(startR, endR));
		oVisit = new boolean[R];
		uVisit = new boolean[R];
		//int time = 1;
		bfs();
		if(flag) {
			System.out.println(time+1);
		} else System.out.println("false = "+ -1);
	}
	private static void bfs() {
		int time = 1;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				dock current = q.poll();
				for(int dir=0;dir<2;dir++) {
					int oor = dr[dir]*time;
					int or = (current.oR + dr[dir]) * time;
					int ur = (current.uR + dr[dir]) * time;
					System.out.println("or = " + or);
					System.out.println("ur = " + ur);
					
					if(rangeCheck(or,ur)) {
						if(or == ur) {
							System.out.println("pass = " + time);
							flag = true;
							break;
							
						}
					
						
						if(!oVisit[or]) {
							q.add(new dock(or, 0));
							oVisit[or] = true;
							map[or] = 1;
						}
						if(!uVisit[ur]) {
							q.add(new dock(0,ur));
							uVisit[ur] = true;
							map[ur] = 2;
						}
					}
				}
			}
			time++;
			System.out.println("bfs 후");
			printData();
		}
		
	}
	private static void printData() {
		for(int row=0;row<map.length;row++) {
			System.out.print(map[row]+ " ");
		}
		System.out.println();
	}
	private static boolean rangeCheck(int or, int ur) {
		if(or >= 0 && or < R && ur >= 0 && ur < R) return true;
			return false;
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		startR = Integer.parseInt(st.nextToken())-1;
		endR = Integer.parseInt(st.nextToken())-1;
		map = new int[R];
		
		map[startR] = 1;
		map[endR] = 2;
	}
}
