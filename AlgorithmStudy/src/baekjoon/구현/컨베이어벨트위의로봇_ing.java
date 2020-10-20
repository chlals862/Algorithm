package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 컨베이어벨트위의로봇_ing {
	static int N,K,count,hpCnt;
	static boolean end;
	static int[] belt; //내구도
	static int[] robot; //로봇 위치
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
		rotation();
	}
	private static void rotation() {
		count = 0;
		while(true) {
		end = false;
		
		int hpCnt = 0;
		
		count++;
		//1.벨트가 한 칸 회전
		int temp = belt[2*N];
		int rTemp = robot[2*N];
		for(int row=2*N; row >= 1; row--) {
			belt[row] = belt[row-1];
			robot[row] = robot[row-1];
		}
		belt[1] = temp;
		robot[1] = rTemp;
		//내려감
		//robot[2*N] = 0;
		printMap();
		System.out.println("robot");
		printMap2();
		//2.
		//가장 먼저 벨트에 올라간 로봇부터,(robot[1])
		//벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. robot[2] = robot[1] 
		//만약 이동할 수 없다면 가만히 있는다.
		//로봇이 이동하기 위해서는 이동하려는 칸에 로봇이 없으며,
		//그 칸의 내구도가 1 이상 남아 있어야 한다.
		for(int row=2;row<=2*N;row++) {
		if(robot[1] == 1 && robot[row] == 0 && belt[row] > 0) {
			System.out.println("이동");
			robot[row] = robot[1];
			belt[row] -= 1;
			printMap();
			printMap2();
		}else if(robot[row] == 1) robot[1] = robot[1];
		}
		//3.
		//올라가는 위치에 로봇이 없다면 로봇을 하나 올림
		if(robot[1] == 0 && belt[1] > 0) {
			System.out.println("로봇 올림");
			robot[1] = 1;
			belt[1] -= 1;
			printMap();
			printMap2();
		}
			for(int row=1;row<=2*N;row++) {
				if(belt[row] == 0 ) {
					hpCnt++;
				}
			}
			System.out.println("내구도  :" + hpCnt);
			if(hpCnt > K) end = true;
			if(end) break;
		}//while
		System.out.println("count = " + count);
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); 
		belt = new int[2*N+1];
		robot = new int[2*N+1];
		st = new StringTokenizer(br.readLine());
		for(int row=1;row<=2*N;row++) {
			belt[row] = Integer.parseInt(st.nextToken());
		}
		for(int row=1;row<=2*N;row++) {
			robot[row] = 0;
		}
		//printMap();
	}
	private static void printMap() {
		for(int row=1;row<belt.length;row++) {
			System.out.print(belt[row] + " ");
		}
		System.out.println();
	}
	private static void printMap2() {
		for(int row=1;row<belt.length;row++) {
			System.out.print(robot[row] + " ");
		}
		System.out.println();
	}

}
