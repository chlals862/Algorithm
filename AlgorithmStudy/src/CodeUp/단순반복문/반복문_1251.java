package CodeUp.단순반복문;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class 반복문_1251 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		for (int row = 1; row <= 100; row++) {
			bw.write(row + " ");
		}
		bw.flush();
		bw.close();
	}
}
