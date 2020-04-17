package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
public class 수정렬하기3 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int inputNum = Integer.parseInt(br.readLine());
		
		//ArrayList<Integer> list = new ArrayList<Integer>();
		int[] list = new int[inputNum];
		for(int i=0; i<inputNum; i++) {
			int num = Integer.parseInt(br.readLine());
			
			//list.add(num);
			list[i] = num;
			
		}
		//Collections.sort(list);
		Arrays.sort(list);
		
		for(int i=0; i<inputNum;i++) {
			//System.out.println(list[i]);
		//}
		
		bw.write(list[i]+"\n");
	}
		bw.flush();
		bw.close();
	}
}
