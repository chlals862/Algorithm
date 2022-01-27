package baekjoon.큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 카드1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		while(!q.isEmpty()) {
			int num = q.poll(); //젤 위 카드 빼고 저장
			bw.write(num+" ");
			
			if(q.isEmpty()) break;
			int num2 = q.poll();
			q.offer(num2);
		}
		bw.flush();
		bw.close();
	}

}
