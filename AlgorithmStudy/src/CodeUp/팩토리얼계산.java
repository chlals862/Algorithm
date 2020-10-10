package CodeUp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 팩토리얼계산 {
	static int num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int factorial(int num) {
		if(num == 1) {
			return 1;
		}else 
			return num = num *= factorial(num-1);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		num = Integer.parseInt(br.readLine());
		bw.write(factorial(num)+"\n");
		bw.flush();
		bw.close();
	}
}
