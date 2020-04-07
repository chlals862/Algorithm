package 코딩테스트.라인_2020;

import java.util.Scanner;

/*
	 * 임의의 문자열 inputString이 입력됨
	 * 공백으로만 이루어진 문자열은 입력되지 않음
	 * 입력 문자열의 길이는 1이상
	 * 최대길이는 명시 X
	 * --------------------------------------------
	 * 괄호들이 정상적으로 사용되었는지 검증한 결과를 반환
	 * 괄호는 (),{},[],<> 4종류
	 * 괄호의 여닫는 특징만을 검증하며
	 * 열려 있는 어떤 괄호에 대해서 짝이 다른 닫히는 괄호에 영향을 주지 않음
	 * ex) []와 [) 는 모두 잘 열고 잘 닫았기 때문에 정상
	 * 정상이라면 총 괄호 쌍의 수, 
	 * 비정상(괄호 쌍이 정상적인 순서로 표현되지 않은 경우) -> -1반환
	 * 
	 * */

public class Line_CodingTest1_1 {

	public static void main(String[] args) {

		System.out.println(Output("<><"));
	}

	// 첫번째가 ]로 하면 무조건 return -1
	public static int Output(String inputString) {
		// []가 포함될땐 +1 || 비정상 -1 || 없으면 0
		int result = 0;
		int input = 0; // 출력값

		for (int i = 0; i < inputString.length(); i++) {

			if (inputString.charAt(i) == '(' || inputString.charAt(i) == '{' || inputString.charAt(i) == '['
					|| inputString.charAt(i) == '<') {
				result += 1;

			} else if (inputString.charAt(i) == ')' || inputString.charAt(i) == '}' || inputString.charAt(i) == ']'
					|| inputString.charAt(i) == '>') {
				result -= 1;

				if (result == 0) {
					input++;
				} else if (result < 0 ) {
					return -1;
				}
			}
		} //for
		//입력이 <>< 일때 -1이 나와야 할떄
		if (result != 0) { 
			return -1;
		}
		return input;
	}//Output
}
