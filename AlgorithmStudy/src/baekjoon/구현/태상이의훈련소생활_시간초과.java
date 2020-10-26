package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 태상이의훈련소생활_시간초과 {
	static int N,K,startR,endR,num;
	static int[] land;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		land = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int row=1;row<=N;row++) {
			land[row] = Integer.parseInt(st.nextToken());
		}
		printMap();
		for(int k=1;k<=K;k++) {
			st = new StringTokenizer(br.readLine());
			startR = Integer.parseInt(st.nextToken());
			endR = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			if(num >= 0) {
				for(int row=startR;row<=endR;row++) 
					land[row] = land[row]+Math.abs(num);
				printMap();
			}else if(num < 0) {
				for(int row=startR;row<=endR;row++) 
					land[row] = land[row]-Math.abs(num);
				printMap();
			}
		}
		//printMap();
		bw.flush();
		bw.close();
	}
	private static void printMap() throws IOException {
		for(int row=1;row<land.length;row++) {
			bw.write(land[row]+" ");
		}
		bw.write("\n");
	}
}
