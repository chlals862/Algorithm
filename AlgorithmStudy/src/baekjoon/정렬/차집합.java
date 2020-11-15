package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 차집합 {
	static int count;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		Set<Integer> set = new HashSet<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int row=0;row<A;row++) set.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		for(int row=0;row<B;row++) {
			int num = Integer.parseInt(st.nextToken());
			if(set.contains(num)) {
				count++;
				set.remove(num);
			}
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(set);
		Collections.sort(list);
		if(count > 0) {
			bw.write(list.size()+"\n");
			for(Integer result : list) bw.write(result+" ");
		}else bw.write(0+"");
		bw.flush();
		bw.close();
	}
}
