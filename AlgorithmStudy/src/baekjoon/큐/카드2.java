package baekjoon.큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=1;i<=N;i++) q.add(i);
		while(q.size() > 1) {
			q.poll();//맨 앞 원소 삭제
			q.add(q.poll()); //원소 버리고, 버려진 원소 맨 뒤에 삽입
		}
		bw.write(q.poll()+"");
		bw.flush();
		bw.close();
	}

}
