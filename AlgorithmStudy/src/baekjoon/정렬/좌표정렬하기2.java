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

public class 좌표정렬하기2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int input;
	static StringTokenizer st;
	
	static ArrayList<Point> pointer = new ArrayList<Point>();
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		inputData();
		sorting();
		outputdata();
		
		bw.flush();
		bw.close();
	}

	private static void outputdata() throws IOException {
		for(Point p : pointer)
			bw.write(p.x + " " + p.y+"\n");
	}

	private static void sorting() {
		//1.y오름차순
		//2.y가 같다면 x오름차순
		
		Collections.sort(pointer, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				if(p1.y == p2.y) 
					return Integer.compare(p1.x, p2.x);
				else 
					return Integer.compare(p1.y, p2.y);
			}
		});
		
	}

	private static void inputData() throws NumberFormatException, IOException {
		input = Integer.parseInt(br.readLine());
		
		for(int i=0;i<input;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pointer.add(new Point(x, y));
			
		}
	}
}
