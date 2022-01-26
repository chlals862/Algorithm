package baekjoon.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 음계 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int[] arr1 = {1,2,3,4,5,6,7,8};
		int[] arr2 = {8,7,6,5,4,3,2,1};
		int[] res = new int[8];
		//int count = 1;
		for(int i=0;i<res.length;i++) {
			res[i] = Integer.parseInt(st.nextToken()); 
		}
		
		if(Arrays.equals(res, arr1)) bw.write("ascending"+"");
		else if(Arrays.equals(res, arr2)) bw.write("descending");
		else bw.write("mixed");
		bw.flush();
		bw.close();
	}

}
