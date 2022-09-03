package baekjoon.시뮬레이션;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 스위치_켜고_끄기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//1 : 켜짐 
		//0 : 꺼짐
		
		//남학생 -> 스위치번호가 자기가 받은 수의 배수이면
		//스위치 상태 바꾸기 1->0 , 0->1
		//ex) 3을 받았다면 3,6 스위치 바꾸기
		
		
		//여학생 -> 자기가 받은 수의 번호가 붙은 스위치를 중심으로 좌우가 대칭이면서, 가장 많은 스위치를 
		//		  포함하는 구간을 찾아서 그 구간에 속한 스위치를 상태를 모두 바꿈 -> 구간에 속한 스위치 개수는 항상 홀수
		
		int cnt = Integer.parseInt(br.readLine());
		int[] arr = new int[cnt];
		st = new StringTokenizer(br.readLine());
		for(int row=0;row<arr.length;row++) {
			arr[row] = Integer.parseInt(st.nextToken());
		}
		
		int peopleCnt = Integer.parseInt(br.readLine());
		
		
		
	}
}
