package baekjoon.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 수찾기 {
	static int N,M;
	static int[] targetList;
	static HashSet<Integer> startList;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		setData();
	}
	//2중 포문 X
	private static void setData() throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		startList = new HashSet<Integer>();
		for(int row=0;row<N;row++) {
			startList.add(Integer.parseInt(st.nextToken()));
		}

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		targetList = new int[M];
		for(int row=0;row<M;row++) {
			targetList[row] = Integer.parseInt(st.nextToken());
		}

		for(int row=0;row<targetList.length;row++) {
			if(startList.contains(targetList[row])) {
				bw.write(1+"\n");
			}else {
				bw.write(0+"\n");
			}
		}
		bw.flush();
		bw.close();
	}

}
