package CodeUp.단순반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 반복문_1276 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		bw.write(factiorial(num)+"");
		bw.flush();
		bw.close();
	}
	private static int factiorial(int num) {
		if(num == 1) return 1;
		else return num * factiorial(num-1);
	}
}
