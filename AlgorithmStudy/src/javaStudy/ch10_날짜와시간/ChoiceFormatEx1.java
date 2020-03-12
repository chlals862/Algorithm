package javaStudy.ch10_날짜와시간;

import java.text.ChoiceFormat;

public class ChoiceFormatEx1 {
	/* ChoiceFormat - 특정 범위에 속하는 값을 문자열로 변환
	 * 연속적 또는 불연속적인 범위의 값들을 처리하는 데 있어서 if문이나 switch문을 적절하지 못한 경우가 있음
	 * 복잡하게 처리될 수 밖에 없었던 코드를 간단하고 직관적으로 만들 수 있음
	 * */
	public static void main(String[] args) {
		double[] limits = {60,70,80,90}; //낮은 값부터 큰 값의 순서로 적어야함★★★★★
		//limits, grades간의 순서와 개수를 맞춰야 한다★★★★★
		String[] grades = {"D","C","B","A"};
		
		int[] scores = {100,95,88,70,52,60,70};
		
		ChoiceFormat form = new ChoiceFormat(limits, grades);//limits -> 범위의 경계값   grades -> 범위에 포함된 값을
		
		for(int i=0;i<scores.length;i++) {
			System.out.println(scores[i]+":"+ form.format(scores[i]));
		}
	}
}
	/* 경계값은 반드시 오름차순으로 정렬되어 있어야 한다.
	 * 치환될 문자열의 개수는 경계값에 의해 정의된 범위의 개수와 일치해야함
	 * */