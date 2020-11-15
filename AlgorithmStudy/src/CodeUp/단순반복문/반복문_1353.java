package CodeUp.단순반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 반복문_1353 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		for(int row=1;row<=N;row++) {
			for(int col=1;col<=row;col++) {
				bw.write('*');
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
