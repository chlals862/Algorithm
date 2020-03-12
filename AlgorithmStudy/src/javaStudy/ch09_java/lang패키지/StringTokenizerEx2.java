package javaStudy.ch09_java.lang패키지;

import java.util.StringTokenizer;

public class StringTokenizerEx2 {

	public static void main(String[] args) {
		
		String expression = "x=100*(200+300)/2";
		//StringTokenizer(String str,String delim,boolean returnDelims)
		//문자열을 지정된 구분자로 나누는 st생성 후 returnDelims true시 구분자도 토큰으로 간주됨
		StringTokenizer st = new StringTokenizer(expression, "+-*/=()",true); //-> StringTokenizer는 단 한 문자의 구분자만 사용할 수 있기 떄문에
		//"+/*/=()" 전체가 하나의 구분자가 아니라 각각의 문자가 모두 구분자로 인식됨
		//만일 구분자가 두 문자 이상이라면 Scanner나 String클래스의 split메서드를 사용해야 함
		
		while(st.hasMoreTokens()) {//토큰이 남아 있다면
			System.out.println(st.nextToken());
		}
		/* true시 결과 : x = 100 * ( 200 + 300 ) / 2  -> 구분자도 토큰으로 간주됨
		 * false시 결과: x 100 200 300 2
		 * */
	}
}
