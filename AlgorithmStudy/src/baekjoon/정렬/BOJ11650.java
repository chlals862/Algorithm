package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ11650 {
	static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Point> list = new ArrayList<Point>();
		
		while(N --> 0) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			list.add(new Point(X, Y));
		}
		
		Collections.sort(list, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if(o1.x == o2.x) {
					return Integer.compare(o1.y, o2.y);
				}
				return Integer.compare(o1.x, o2.x);
			}
		});
		
		for(Point result : list) {
			bw.write(result.x + " " + result.y+"\n"); 
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
