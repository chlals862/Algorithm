package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 리모컨 {
	static int result;
	static int startTem,endTem;
	static Queue<Integer> q;
	static boolean[] visit;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		setData();
	}
	private static void setData() throws IOException {
		st = new StringTokenizer(br.readLine());
		startTem = Integer.parseInt(st.nextToken());
		endTem = Integer.parseInt(st.nextToken());
		visit = new boolean[endTem];
		q = new LinkedList<Integer>();
		q.add(startTem);
		visit[startTem] = true;
		bfs();
		bw.write(result-1+"");
		bw.flush();
		bw.close();
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0;i<size;i++) {
				int cr = q.poll();
				System.out.println("cr = " + cr);
				if(cr == endTem) {
					System.out.println("Goal");
					return;
				} else {
					int nr = cr + 1;
					if(rangeCheck(nr) && !visit[nr]) {
						queAdd(nr);
					}
					nr = cr - 1;
					if(rangeCheck(nr) && !visit[nr]) {
						queAdd(nr);
					}
					nr = cr + 5;
					if(rangeCheck(nr) && !visit[nr]) {
						queAdd(nr);
					}
					nr = cr - 5;
					if(rangeCheck(nr) && !visit[nr]) {
						queAdd(nr);
					}
					nr = cr + 10;
					if(rangeCheck(nr) && !visit[nr]) {
						queAdd(nr);
					}
					nr = cr - 10;
					if(rangeCheck(nr) && !visit[nr]) {
						queAdd(nr);
					}
					//System.out.println("nr = " + nr);
				}

			}
			result++;
			
		}
		
	}
	private static void queAdd(int nr) {
		q.add(nr);
		visit[nr] = true;
	}
	private static boolean rangeCheck(int nr) {
		if(nr >= 0 && nr < visit.length) return true;
			return false;
	}
}
