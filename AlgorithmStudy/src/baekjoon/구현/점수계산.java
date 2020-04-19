package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 점수계산 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {

		// List list = new ArrayList(8);
		int[] num1 = new int[8];
		int[] min = new int[3];
		for (int i = 0; i < 8; i++) {
			st = new StringTokenizer(br.readLine());
			num1[i] = Integer.parseInt(st.nextToken());
		}
		int[] num2 = Arrays.copyOf(num1, num1.length);
		Arrays.sort(num2);// 0 20 30 33 48 50 64 66
							// 20 30 50 48 33 66 0 64
							// 0 1 2 3 4 5 6 7
		//최소값 3개 빼놓기
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < num1.length; j++) {
				if (num2[i] == num1[j]) {
					min[i] = j;
				}
			}
		}

		for (int i = 0; i < num1.length; i++) {
			if (i == min[0] || i == min[1] || i == min[2])
				continue;
			sum += num1[i];

		}
		System.out.println(sum);

		for (int i = 0; i < num1.length; i++) {
			if (i == min[0] || i == min[1] || i == min[2])
				continue;
			//idx는 0부터니까
			System.out.print(i + 1 + " ");

		}

	}
}
