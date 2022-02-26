package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class 차집합 {
	static int num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		TreeSet<Integer> A = new TreeSet<Integer>();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<a;i++) 
			A.add(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<b;i++) {
			num = Integer.parseInt(st.nextToken());
			if(A.contains(num)) A.remove(num);
		}
		bw.write(A.size()+"\n");
		for(Integer res : A) bw.write(res+" ");
		bw.flush();
	}
}
