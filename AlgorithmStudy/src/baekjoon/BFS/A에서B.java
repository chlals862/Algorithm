package baekjoon.BFS;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class A에서B {
	static int time;
	static long A,B;
	static boolean flag;
	static Queue<Long> q;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		setData();
	}

	private static void setData() throws IOException {
		Scanner sc = new Scanner(System.in);
		A = sc.nextLong();
		B = sc.nextLong();
		q = new LinkedList<Long>();
		q.add(A);
		bfs();
		if(flag) {
			bw.write(time+1 + "\n");
		} else {
			bw.write(-1+"\n");
		}
		bw.flush();
		bw.close();
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				Long cr = q.poll();
					if(cr == B) {
						flag = true;
						return;
					}
					long nr = cr * 2;
					if(rangeCheck(nr)) {
						q.add(nr);
					}
					 nr = cr * 10 +1;
					 if(rangeCheck(nr)) {
						 q.add(nr);
					 }
			}
			time++;
		}
		
	}

	private static boolean rangeCheck(long cr) {
		if (cr >= A && cr <= B)
			return true;
		return false;
	}
}
