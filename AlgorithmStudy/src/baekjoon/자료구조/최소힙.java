package baekjoon.자료구조;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소힙 {
	static int T;
	static int num;
	static int count;
	static int outputT;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				//pq가 비어있으면 0 출력
				if (pq.isEmpty()) {
					bw.write(0 + "\n");
				} else
					//비어있지 않다면 출력
					bw.write(pq.poll() + "\n");
			} else { //입력값이 0이 아닌 자연수면 pq에 넣어줌
				pq.add(num);
			}
		}
		bw.flush();
		bw.close();
	}
}
