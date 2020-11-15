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

public class 듣보잡 {
	static int A,B,cnt;
	static HashSet<String> set;
	static ArrayList<String> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		set = new HashSet<String>();
		list = new ArrayList<String>();
		for(int a=0;a<A;a++) {
			String str1 = br.readLine();
			set.add(str1);
		}
		for(int b=0;b<B;b++) {
			String str2 = br.readLine();
			if(set.contains(str2)) {
				cnt++;
				list.add(str2);
			}
		}
		Collections.sort(list);
		bw.write(cnt+"\n");
		for(String result : list) bw.write(result+"\n");
		bw.flush();
	}
}
