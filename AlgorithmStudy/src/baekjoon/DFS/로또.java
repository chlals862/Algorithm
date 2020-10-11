package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 로또 {
	static int T;
	static int[] arr;
	static boolean[] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
			arr = new int[T];
			visit = new boolean[T];
			System.out.println("T -" + T);
			for(int row=0;row<T;row++) {
				arr[row] = Integer.parseInt(st.nextToken());
			}
			printMap();
			if(T == 0) return;
		}
	}
	private static void printMap() {
		for(int row=0;row<arr.length;row++) {
			System.out.print(arr[row]+ " ");
		}
		System.out.println();
	}
}
