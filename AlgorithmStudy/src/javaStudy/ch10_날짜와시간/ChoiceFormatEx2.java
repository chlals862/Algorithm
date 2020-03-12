package javaStudy.ch10_날짜와시간;

import java.text.ChoiceFormat;

public class ChoiceFormatEx2 {
	/*
	 * 패턴은 구분자로 '#'와 '<'두 가지를 재공하는데 'limit#value'의 형태로 사용
	 * 
	 * */
	public static void main(String[] args) {
		
		//결과에서 90은 A지만, 80은 B가 아닌 C인것에 주목
		String pattern = "60#D|70#C|80<B|90#A"; //'#'은 경계값을 범위에 포함시키지만, '<'는 포함시키지 않음'
		int[] scores = {91,90,80,88,70,52,60};
		
		ChoiceFormat form = new ChoiceFormat(pattern);
		
		for(int i=0;i<scores.length;i++) 
			System.out.println(scores[i] + ":" + form.format(scores[i]));
	}
}
