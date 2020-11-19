package baekjoon.큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제 {
	static int N,K;
	static Queue<Integer> q = new LinkedList<Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		sb.append("<");
		while(q.size() != 1) {
			for(int row=0;row<K-1;row++) {
				q.add(q.poll());
			}
			sb.append(q.poll()+", ");
		}
		sb.append(q.poll()+">");
		bw.write(sb+"");
		bw.flush();
		bw.close();
	}

}
