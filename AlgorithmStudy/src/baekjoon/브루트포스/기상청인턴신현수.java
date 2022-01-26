package baekjoon.브루트포스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 기상청인턴신현수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken()); //연속적인 K일
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1;i<arr.length;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<=N-K;i++) {
			int sum = 0;
			for(int j=0;j<K;j++) {
				sum += arr[i+j+1];
			}
			list.add(sum);
			//System.out.println("sum = " + sum);
		}
		Collections.sort(list, Collections.reverseOrder());
		//for(int i=1;i<arr.length;i++) System.out.print(arr[i]+" ");
		bw.write(list.get(0)+"");
		bw.flush();
		bw.close();
	}

}
