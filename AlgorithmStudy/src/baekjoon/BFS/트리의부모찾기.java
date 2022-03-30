package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
	static int N;
	//static ArrayList<Integer>[] list;
	static int[] parents;
	static boolean[] visit;
	static Queue<Integer> q = new LinkedList<Integer>();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		List<Integer> list[] = new ArrayList[N+1];
		parents = new int[N+1];
		visit = new boolean[N+1];
		
		for(int row=0;row<list.length;row++) {
			list[row] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		q.add(1);
		
		while(!q.isEmpty()) {
			Integer num = q.poll();
			for(Integer res : list[num]) {
				if(!visit[res]) {
					visit[res] = true;
					parents[res] = num;
					q.add(res);
				}
			}
		}
		for(int row=2;row<parents.length;row++) bw.write(parents[row]+"\n");
		bw.flush();
	}

}
