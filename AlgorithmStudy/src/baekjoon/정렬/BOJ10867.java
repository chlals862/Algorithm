package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ10867 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		HashSet<Integer> set = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine());
		while(N --> 0) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		ArrayList<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		for(Integer result : list) {
			bw.write(result + " ");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
