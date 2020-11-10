package CodeUp.단순반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 반복문_1281 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int sum = 0;
		for(int row=a;row<=b;row++) {
			if(row % 2 != 0) {
				if(row !=a) {
				System.out.printf("+%d",row);
				sum += row;
				}else if(row == a) {
					System.out.printf("%d",row);
					sum += row;
				}
			}else {
				System.out.printf("-%d",row);
				sum -= row;
			}
		}
		System.out.printf("=%d",sum);
	}
}
