package CodeUp.배열;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1430_ing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int count = 0;
		int num1 = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] arr1 = new int[num1];
			for(int row=0;row<arr1.length;row++) {
				arr1[row] = Integer.parseInt(st.nextToken());
			}
		int num2 = Integer.parseInt(br.readLine());
		int[] arr2 = new int[num2];
		st = new StringTokenizer(br.readLine());
			for(int row=0;row<arr2.length;row++) {
				arr2[row] = Integer.parseInt(st.nextToken());
			}
		int[] result = new int[num2];

		for(int row=0;row<arr2.length;row++) {
			for(int col=0;col<arr1.length;col++) {
				if(arr2[row] == arr1[col]) {
					result[row] = 1;
					break;
				}else if(arr2[row] != arr1[col]) {
					result[count] = 0;
				}
			}
		}
		
		for(int row=0;row<result.length;row++) bw.write(result[row]+" ");
		bw.flush();
		
	}
}
