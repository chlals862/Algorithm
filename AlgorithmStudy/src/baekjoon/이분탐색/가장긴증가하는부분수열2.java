package baekjoon.이분탐색;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2 {
	static int N;
	static int[] arr;
	static ArrayList<Integer> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		list = new ArrayList<Integer>();
		list.add(0);
		st = new StringTokenizer(br.readLine(), " ");
		for (int row = 0; row < N; row++) {
			int temp = arr[row] = Integer.parseInt(st.nextToken());
			
			if (temp > list.get(list.size() - 1)) {
				list.add(temp);
			//System.out.println("temp = " + temp);
			}
			else {
				int left = 0;
				int right = list.size() - 1;
				while (left < right) {
					int mid = (left + right) >> 1;
					if (list.get(mid) >= temp) {
						right = mid;
					} else left = mid + 1;
				}
				list.set(right, temp);
			}
		}
		bw.write(list.size() - 1 + "");
		bw.flush();
		bw.close();
	}
}
