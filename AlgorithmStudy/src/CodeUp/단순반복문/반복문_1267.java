package CodeUp.단순반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 반복문_1267 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int sum = 0;
		int[] num = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int row=0;row<n;row++) {
			num[row] = Integer.parseInt(st.nextToken());
			if(num[row] % 5 == 0) {
				sum+=num[row];
			}
		}
		bw.write(sum+"");
		bw.flush();
		bw.close();
	}
}
