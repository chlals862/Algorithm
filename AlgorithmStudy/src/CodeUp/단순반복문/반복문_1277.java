package CodeUp.단순반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 반복문_1277 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int result[] = new int[size];
		st = new StringTokenizer(br.readLine());
		for(int row=0;row<size;row++) {
			result[row] = Integer.parseInt(st.nextToken());
		}
		bw.write(result[0] + " " + result[size/2] + " " + result[size-1]);
		bw.flush();
		bw.close();
	}
}
