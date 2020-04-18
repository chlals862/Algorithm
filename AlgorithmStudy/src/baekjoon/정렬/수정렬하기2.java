package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;


public class 수정렬하기2 {
	static ArrayList<Integer> list;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		
		int inputNum = Integer.parseInt(br.readLine());
		list = new ArrayList<Integer>(inputNum);
		
		for(int i=0;i<inputNum;i++) {
			int num = Integer.parseInt(br.readLine());
			list.add(num);
		}
		Collections.sort(list);
		
		for(int i=0;i<list.size();i++) {
			//System.out.println(list.get(i));
			bw.write(list.get(i)+"\n");
			
		}
		bw.flush();
		bw.close();
	}
}
