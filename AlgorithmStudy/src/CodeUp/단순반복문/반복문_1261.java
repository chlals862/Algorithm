package CodeUp.단순반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 반복문_1261 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[10];
		int[] result = new int[10];
		for(int row=0;row<10;row++) {
			arr[row] = Integer.parseInt(st.nextToken());
			if(arr[row] % 5 == 0) {
				result[0] = arr[row];
				break;
			}else result[0] = 0;
		}
		bw.write(result[0]+"");
		bw.flush();
		//bw.close();
	}
}
