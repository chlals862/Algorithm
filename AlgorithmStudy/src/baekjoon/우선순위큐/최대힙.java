package baekjoon.우선순위큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최대힙 {
	static int T;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0) {
				if(pq.isEmpty()) {
					bw.write(0+"\n");
				}else bw.write(pq.poll()+"\n");
				
			}else pq.add(num);
		} // testCase
		bw.flush();
		bw.close();
	}
}
