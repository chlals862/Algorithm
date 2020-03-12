package javaStudy.ch09_java.lang패키지;

import java.util.StringTokenizer;

public class StringTokenizerEx1 {
	/*	StringTokenizer -> 긴 문자열을 지정된 구분자(delimiter)를 기준으로 토큰(token)이라는 여러개의 문자열로 잘라내는 데 사용됨
	 * Ex) -> "100.200.300.400"이라는 문자열이 있을 때 '.'를 구분자로 잘라내면 
	 * "100","200","300","400"이라는 4개의 문자열을 얻을 수 있음
	 * 
	 * StringTokenizer를 이용하는 방법 이외에도 String의 split이나 
	 * Scanner의 useDelimiter를 사용할 수도 있지만,
	 * 이 두 가지 방법은 정규식 표현을 사용해야하므로 정규식 표현에 익숙하지 않은 경우 StringTokenizer를 사용하는 것이 간단함
	 * 
	 * 하지만 StringTokenizer는 구분자로 단 하나의 문자 밖에 사용하지 못하기 때문에
	 * 보다 복잡한 형태의 구분자로 문자열을 나누어야 할 때는 어쩔 수 없이 정규식을 사용하는 메서드를 사용해야 함
	 * */
	
	
	
	/*
	 * StringTokenizer(String str, String delim) -> 문자열(str)을 지정된 구분자(delim)로 나눔
	 * StringTokenizer(String str, String delim, boolean returnDelims) -> 문자열을 지정된 구분자로 나누고, returnDelims의 값을 true로 하면 구분자도 토큰으로 간주됨
	 * int countTokens() -> 전체 토큰의 수를 반환
	 * boolean hasMoreTokens() -> 토큰이 남아 있는지 알려줌
	 * String nextToken() -> 다음 토큰을 반환
	 * */
	
	public static void main(String[] args) {
		String source = "100,200,300,400.500";
		StringTokenizer st = new StringTokenizer(source,","); //구분자 ','로 source를 토큰으로 나눔
		
		while(st.hasMoreTokens()) { //토큰이 남아 있다면
			System.out.println(st.nextToken()); //다음 토큰을 반환 -> 500이 남았지만 구분자가 ','가 아닌 '.'
		}
	}
	
}
