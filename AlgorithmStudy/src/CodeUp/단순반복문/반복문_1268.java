package CodeUp.단순반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 반복문_1268 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] num = new int[n];
		int count = 0;
		st = new StringTokenizer(br.readLine());
		for(int row=0;row<n;row++) {
			num[row] = Integer.parseInt(st.nextToken());
			if(num[row] % 2 == 0) count++;
		}
		bw.write(count+"");
		bw.flush();
		bw.close();
	}
}
