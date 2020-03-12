package javaStudy.ch09_java.lang패키지;

public class StringEx6 {
	/* 				-문자열과 기본형간의 변환의 예제-
	 
	 * join() -> 여러문자열 사이에 구분자를 넣어서 결합  -- jdk1.8부터 추가됨
	 * 구분자로 문자열을 자르는 split()과 반대의 작업을 한다고 생각하면 됨
	 * */
	public static void main(String[] args) {
		int iVal = 100;
		String strVal = String.valueOf(iVal); //int -> String으로 변환
		
		double dVal = 200.0;
		String strVal2 = dVal + ""; //int -> String으로 변환2
		
		double sum = Integer.parseInt("+"+strVal) + Double.parseDouble(strVal2);
		double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);
		
		System.out.println(String.join("", strVal,"+",strVal2,"=")+sum);
		System.out.println(strVal+"+"+strVal2+"="+sum2);
	}
}
