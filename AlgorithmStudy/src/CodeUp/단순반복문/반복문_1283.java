package CodeUp.단순반복문;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 반복문_1283 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		 st = new StringTokenizer(br.readLine());
		 float cash = Float.parseFloat(st.nextToken());
		 int result = (int) cash;
		 st = new StringTokenizer(br.readLine());
		 int k = Integer.parseInt(st.nextToken());
		 int[] arr = new int[k];
		 st = new StringTokenizer(br.readLine());
		 for(int row=0;row<k;row++) {
			 arr[row] = Integer.parseInt(st.nextToken());
		 }
		 for(int row=0;row<arr.length;row++) {
			float cal = cash*arr[row]/100;
			if(arr[row] > 0) {
				cash += cal;
			}else cash += cal;
		 }
		 	cash = Math.round(cash);
		 	if((int)cash == result) {
		 	bw.write((int)cash - result+"\n");
		 	bw.write("same");
		 	}else if((int)cash > result) {
		 		bw.write((int)cash - result + "\n");
		 		bw.write("good");
		 	}else {
		 		bw.write((int)cash - result + "\n");
		 		bw.write("bad");
		 	}
		 	bw.flush();
		 	bw.close();
	}
}
