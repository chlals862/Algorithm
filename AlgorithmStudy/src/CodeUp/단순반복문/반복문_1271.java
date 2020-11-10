package CodeUp.단순반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 반복문_1271 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int[] arr = new int[num];
		st = new StringTokenizer(br.readLine());
		for(int row=0;row<num;row++) {
			arr[row] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		bw.write(arr[num-1]+"");
		bw.flush();
		bw.close();
	}
}
