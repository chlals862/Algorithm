package baekjoon.그리디알고리즘;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _30 {
	static int sum;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int row=0;row<str.length();row++) {
			list.add(str.charAt(row)-'0');
			sum += str.charAt(row)-'0';
		}
		Collections.sort(list);
		if(sum % 3 == 0&& list.get(0) == 0) {
			for(int row=list.size()-1;row>=0;row--) bw.write(list.get(row)+"");
		}else bw.write(-1+"\n");
		bw.flush();
	}

}
