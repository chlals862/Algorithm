package CodeUp.단순반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 반복문_1274 {
	static boolean prime;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int num = Integer.parseInt(st.nextToken());
		int count = 0;
		for(int row=1;row<=num;row++) {
			if(num % row == 0) {
				count++;
				if(count == 2) {
					prime = true;
				}else prime = false;
			}
		}
		if(prime) bw.write("prime");
		else bw.write("not prime");
		bw.flush();
		bw.close();
	}
}
