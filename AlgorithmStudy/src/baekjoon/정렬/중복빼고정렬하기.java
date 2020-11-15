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

public class 중복빼고정렬하기 {
	static int N,num;
	static HashSet<Integer> set = new HashSet<Integer>();
	static ArrayList<Integer> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for(int k=0;k<N;k++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		list = new ArrayList<Integer>(set);
		Collections.sort(list);
		for(Integer result : list) bw.write(result+" ");
		bw.flush();
		bw.close();
	}
}
