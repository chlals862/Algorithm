package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 쿠키의신체측정 {
	static int N, startR, startC, leftArm, rightArm, Body, leftLeg, rightLeg, headR, headC, heartR, heartC;
	static char[][] people;
	static boolean[][] visit;
	static Queue<int[]> q = new LinkedList<int[]>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
		logic();
	}

	private static void logic() {
		int count = 0;
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(people[row][col] == '*') {
					count+=1;
					if(count == 1) {
						heartR = row+1; heartC = col;
						people[heartR][heartC] = '?';
						people[row][col] = '?';
					}
				}
			}
		}
		
		
		q.add(new int[] {heartR,heartC});
		visit[heartR][heartC] = true;
		bfs();
		heartR+=1; heartC+=1;
		//printMap();
		count = 0;
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(people[row][col] == '*') {
					count+=1;
					if(count == 1) {
						q.add(new int[] {row,col});
						visit[row][col] = true;
						people[row][col] =  '?';
						
					}

				}
			}
		}
		leftBFS();
		count = 0;
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				if(people[row][col] == '*') {
					count+=1;
					if(count == 1) {
						q.add(new int[] {row,col});
						visit[row][col] = true;
					}
				}
			}
		}
		rightBFS();
		System.out.println(heartR + " " + heartC);
		System.out.println(leftArm + " " + rightArm + " " + Body + " " + leftLeg + " " + rightLeg);
	}
	private static void rightBFS() {
		rightLeg = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if(rangeCheck(cr+1,cc)) {
					if(people[cr+1][cc] == '*' && !visit[cr+1][cc]) {
						q.add(new int[] {cr+1,cc});
						visit[cr+1][cc] = true;
						people[cr+1][cc] = '?';
						rightLeg+=1;
					}
				}

			}
		}
		
	}

	private static void leftBFS() {
		leftLeg = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				if(rangeCheck(cr+1,cc)) {
					if(people[cr+1][cc] == '*' && !visit[cr+1][cc]) {
						q.add(new int[] {cr+1,cc});
						visit[cr+1][cc] = true;
						people[cr+1][cc] = '?';
						leftLeg+=1;
					}
				}

			}
		}
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int[] currentRC = q.poll();
				int cr = currentRC[0];
				int cc = currentRC[1];
				
				//왼팔
				if(rangeCheck(cr,cc-1)) {
					if(people[cr][cc-1] == '*' && !visit[cr][cc-1]) {
						q.add(new int[] {cr,cc-1});
						visit[cr][cc-1] = true;
						people[cr][cc-1] = '?';
						leftArm+=1;
					}
				}
				if(rangeCheck(cr,cc+1)) {
					if(people[cr][cc+1] == '*' && !visit[cr][cc+1]) {
						q.add(new int[] {cr,cc+1});
						visit[cr][cc+1] = true;
						people[cr][cc+1] = '?';
						rightArm+=1;
					}
				}
				if(rangeCheck(cr+1,cc)) {
					if(people[cr+1][cc] == '*' && !visit[cr+1][cc]) {
						q.add(new int[] {cr+1,cc});
						visit[cr+1][cc] = true;
						people[cr+1][cc] = '?';
						Body+=1;
					}
				}
			}
		}
		
	}

	private static boolean rangeCheck(int nr, int nc) {
		if (nr >= 0 && nr < N && nc >= 0 && nc < N)
			return true;
		return false;
	}

	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		people = new char[N][N];
		visit = new boolean[N][N];
		for (int row = 0; row < N; row++) {
			String str = br.readLine();
			for (int col = 0; col < N; col++) {
				people[row][col] = str.charAt(col);
			}
		}

		// printMap();
	}

	private static void printMap() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(people[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void printMap2() {
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				System.out.print(visit[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
