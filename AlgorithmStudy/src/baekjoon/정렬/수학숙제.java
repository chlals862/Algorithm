package baekjoon.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 수학숙제 {
	static int num;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static ArrayList<BigInteger> list = new ArrayList<BigInteger>();
	
	public static void main(String[] args) throws Exception {

		result();
		
		for(BigInteger Output : list) {
			System.out.println(Output);
		}
	}
	//모듈화

	private static void result() throws NumberFormatException, IOException {
		
		//문자열의 개수를 지정
		num = Integer.parseInt(br.readLine());
		
		//문자열의 개수만큼 반복
		for(int i=0;i<num;i++) {
			
			
			String input = br.readLine(); //문자열을 읽음 [한줄]
			String temp = ""; //문자열로 숫자 만들기용
			
			for(int j=0;j<input.length();j++) {
				
				char ch = input.charAt(j); //한글자씩 읽음
				
				if(ch >= '0' && ch <= '9') { //숫자이면 , 알파벳이 아니면
					temp += ch; //문자열을 붙인다
				} else if(temp.length() > 0) { //알파벳일때 , 여태 쌓인 숫자를 빅인티져로 만들어야한다
					BigInteger number = new BigInteger(temp);
					
					list.add(number); //빅인티져 리스트에 담아서
					
					temp = ""; //초기화, 다시 숫자를 만들어야함 ex)43silos0
				}
			}//j
			
			if (temp.length() > 0) { //알파벳을 만나지 못했는데 숫자가 쌓여있는경우
				BigInteger number = new BigInteger(temp);

				list.add(number);

				temp = "";
			}
		}//i
		Collections.sort(list); //정렬
	}
}
