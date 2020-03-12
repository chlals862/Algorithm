package javaStudy.ch05_배열;

public class ArrayEx13_String배열 {
	
	/*
	 * 16진수를 2진수로 변환하는 예제
	 * */
	public static void main(String[] args) {
		
		char[] hex = { 'C','A','F','E'};
		//hex[0] ->C ~ hex[3] -> E
		
		//binary => 0~F 16진수 
		String[] binary = {"0000","0001","0010","0011",
							"0100","0101","0110","0111",
							"1000","1001","1010","1011",
							"1100","1101","1110","1111"};
		String result = "";
		
		for(int i=0;i<hex.length;i++) {
			if(hex[i] >= '0' && hex[i] <='9') {
				result += binary[hex[i]-'0']; //'8'-'0' => 8
			} else { //A~F이면
				result += binary[hex[i]-'A'+10]; //'C'-'A' => 2     +10을 한 이유는 A는 16진수로 10이기 때문
			}
		}
		
		//String(char[] value)
		System.out.println("hex:"+ new String(hex));
		System.out.println("binary:"+result); //결과값 1100101011111110
		                                      //     1100->C
		                                      //     1010->A
		                                      //     1111->F
		                                      //     1110->E
	}
}
