package baekjoon.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 숫자고르기 {
	static int T,last;
	static int[] num;
	static boolean[] visit;
	static ArrayList<Integer> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
		logic();
	}
	private static void logic() throws IOException {
		list = new ArrayList<Integer>();
		for(int row=1;row<=T;row++) {
			visit[row] = true;
			last = row;
			dfs(row);
			visit[row] = false;
		}
		Collections.sort(list);
		bw.write(list.size()+"\n");
		for(Integer answer : list) {
			bw.write(answer+"\n");
		}
		bw.flush();
		bw.close();
	}
	private static void dfs(int row) {
		if(!visit[num[row]]) {
			visit[num[row]] = true;
			dfs(num[row]);
			visit[num[row]] = false;
		}
		if(num[row] == last) {
			list.add(last);
		}
	}
	private static void setData() throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		num = new int[T+1];
		visit = new boolean[T+1];
		for(int t=1;t<num.length;t++) {
			num[t] = Integer.parseInt(br.readLine());
		}
		
	}
}
