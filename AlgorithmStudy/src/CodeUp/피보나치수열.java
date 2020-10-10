package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 피보나치수열 {
	static int fibonacci(int num) {
		if(num == 1) {
			return 1;
		}else if(num == 2) {
			return 1;
		}else {
			return fibonacci(num-1) + fibonacci(num-2);
		}
	}
	static int num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		num = Integer.parseInt(br.readLine());
		bw.write(fibonacci(num)+"");
		bw.flush();
		bw.close();
	}
}
