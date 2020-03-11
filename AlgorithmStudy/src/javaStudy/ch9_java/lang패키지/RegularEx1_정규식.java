package javaStudy.ch9_java.lang패키지;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx1_정규식 {
	/*
	 * data라는 문자열배열에 담긴 문자열 중에서 지정한 정규식과 일치하는 문자열을 출력하는 예제
	 * */
	public static void main(String[] args) {
		String[] data = {"bat","baby","bonus","cA","ca","co","c.","c0","car","combat","count","date","disc"};
		
		//정규식을 매개변수로 Pattern클래스의 static메서드인 Pattern compile(String regex)을 호출하여 Pattern인스터스를 얻음
		Pattern p = Pattern.compile("c[a-z]*"); //c로 시작하는 소문자영단어
		
		 for(int i=0;i<data.length;i++) {
			 
			 //정규식으로 비교할 대상을 매개변수로 Pattern클래스의 Matcher matcher(CharSequence input)를 호출해서 Matcher인스터스를 얻음
			 //CharSequence는 인터페이스로, 이를 구현한 클래스는 CharBuffer,String,StringBuffer가 있음★★
			 Matcher m= p.matcher(data[i]);
			 
			 //Matcher인스턴스에 boolean matches()를 호출해서 정규식에 부합하는지 확인
			 if(m.matches())
				 System.out.print(data[i]+ ",");
			 
		 }
	}
}
