package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ5800 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		for(int i=1;i<=K;i++) {
			int max = 0;
			
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			ArrayList<Integer> list = new ArrayList<Integer>();
			while(N --> 0) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(list, Collections.reverseOrder());
			for(int row=0;row<list.size()-1;row++) {
				max = Math.max(list.get(row) - list.get(row+1), max);
			}
			//bw.write("Class "+(i)+"\n"+"Max "+list.get(0)+","+" Min "+list.get(list.size()-1)+","+" Largest gap "+max+"\n");
			bw.write("Class " + i+"\n" + "Max "+list.get(0) + ", Min " + list.get(list.size()-1) +", Largest gap " + max);
			bw.flush();	
		}
	}
}
