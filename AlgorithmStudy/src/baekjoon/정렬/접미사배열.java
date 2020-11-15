package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 접미사배열 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		ArrayList<String> list = new ArrayList<String>();
		for(int row=0;row<str.length();row++) list.add(str.substring(row));
		Collections.sort(list);
		for(String result : list) bw.write(result+"\n");
		bw.flush();
		bw.close();
	}

}
