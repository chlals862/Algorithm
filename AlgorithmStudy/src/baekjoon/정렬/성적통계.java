package baekjoon.정렬;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 성적통계 {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int K,N,score; //K -> 반의 수, N -> 각 반의 학생 수 , score -> 각 학생의 수학 성적
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();

		for(int i=0; i<K;i++) {
			int N = sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			
			for(int j=0;j<N;j++) {
				arr.add(sc.nextInt());
				//System.out.println(arr.get(j));
				
			}
			Collections.sort(arr,Collections.reverseOrder()); //어레이리스트 내림차순 생각이 나질 않아 검색
		
			//System.out.println(arr);
			int min = arr.get(arr.size()-1); //각 반의 학생중 가장 작은 점수
			int max = arr.get(0); //각 반의 학생중 가장 큰 점수
			int gap = 0; //성적을 ★내림차순★으로 정렬했을 때 가장 큰 인접한 점수 차이를 출력
			
			for(int j=0;j<arr.size()-1;j++) {
				gap = Math.max(arr.get(j)-arr.get(j+1), gap);
				
			}
			bw.write("Class "+(i+1)+"\n"+"Max "+max+","+" Min "+min+","+" Largest gap "+gap+"\n");
		}
		bw.flush();
		bw.close();
	}

}
