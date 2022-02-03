package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 줄세우기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		list.add(-1);
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			int num = Integer.parseInt(st.nextToken());
			list.add(i-num,i);
		}
		for(int i=1;i<=n;i++) bw.write(list.get(i) + " ");
		bw.flush();
		bw.close();
	}

}
