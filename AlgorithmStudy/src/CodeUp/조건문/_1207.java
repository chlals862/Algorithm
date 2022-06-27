package CodeUp.조건문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1207 {
	static int[] arr;
	static int count;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		arr = new int[4];
		
		for(int row=0;row<arr.length;row++) {
			arr[row] = Integer.parseInt(st.nextToken());
		}
		
		for(int row=0;row<arr.length;row++) {
			if(arr[row] == 1) count++;
		}
		
		if(count == 0) {
			bw.write("모");
		}else if(count == 1) {
			bw.write("도");
		}else if(count == 2) {
			bw.write("개");
		}else if(count == 3) {
			bw.write("걸");
		}else bw.write("윷");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
