package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 넴모넴모2020 {
	static int N,Q;
	static int nemo;
	static int[][] map;
	//static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	//3 3 2 입력시
	//map
	//1 1 0
	//1 1 1 
	//1 1 1
	
	//또는 ?
	//map
	//2
	//3
	//3
	
	
	/*
	 3
	 3 3 2
	 * */
	private static void setData() throws IOException {
		Scanner sc = new Scanner(System.in);
		//st = new StringTokenizer(br.readLine());
		//N = Integer.parseInt(st.nextToken());
		//Q = Integer.parseInt(st.nextToken());
		N = sc.nextInt();
		map = new int[N+1][N+1];
		
		for(int t=0;t<N;t++) {
			nemo = sc.nextInt();
			System.out.println("nemo = " + nemo);
			for(int row=N;row>=0;row--) {
				map[row][0] = nemo;
				printMap();
			}
		}
		
	}
	private static void printMap() {
		for(int row=0;row<N;row++) {
			for(int col=0;col<N;col++) {
				System.out.print(map[row][col] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
