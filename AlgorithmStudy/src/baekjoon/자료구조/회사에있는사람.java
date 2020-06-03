package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class 회사에있는사람 {
	static HashSet<String> hash = new HashSet<String>();
	static String name,status;
	static int N;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		for(int row=0;row<N;row++) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			status = st.nextToken();

			if(hash.contains(name)) {
				hash.remove(name);
				continue;
			}else hash.add(name);
		}
		List<String> list = new ArrayList<String>();
		
		for(String name : hash) {
			list.add(name);
		}
		Collections.sort(list);
		
		for(int i=list.size()-1;i>=0;i--) {
			bw.write(list.get(i)+"\n");
		}
		bw.flush();
		bw.close();
	}
}
