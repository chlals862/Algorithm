package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 팰린드롬수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {

		while (true) {
			String str = br.readLine();
			if (str.equals("0")) break;
			String[] arr1 = new String[str.length()];
			String[] arr2 = new String[str.length()];

			for (int row = 0; row < str.length(); row++)
				arr1[row] = str.substring(row, row + 1);

//			for(int row=0;row<str.length();row++) System.out.print(arr1[row]+" ");
			for (int row = 0; row < str.length(); row++)
				arr2[row] = arr1[str.length() - 1 - row];

//			for(int row=0;row<str.length();row++) System.out.println(arr2[row]);
			int equal = 0;
			for (int row = 0; row < str.length(); row++) {
				if (arr1[row].equals(arr2[row])) {
					equal++;
				}
			}
				//길이와 equal가 전부 같다면 전부 같은거
				if(equal == str.length()) bw.write("yes\n");
				else bw.write("no\n");
		} //while
		bw.flush();
		bw.close();
		br.close();
	}
}
