package javaStudy.ch09_java.lang패키지;

import java.util.StringTokenizer;

public class StringTokenizerEx4 {

	public static void main(String[] args) {
		String input = "일조구천삼백사십이억팔천백육십만삼천오백사십삼";
		System.out.println(input);
		System.out.println(hangulToNum(input));
	}
	
	public static long hangulToNum(String input) { //한글을 숫자로 바꿔주는 메서드
		long result = 0; //최종 변환결과를 저장하기 위한 변수
		long tmpResult = 0; //십백천 단위의 값을 저장하기 위한 임시변수
		long num = 0;
		
		final String NUMBER = "영일이삼사오육칠팔구";
		final String UNIT = "십백천만억조";
		//1e8(10의8제곱) -> 1억     1e12(10의12제곱) ->1조 
		final long[] UNIT_NUM = {10,100,1000,10000,(long)1e8,(long)1e12};
		
		StringTokenizer st = new StringTokenizer(input,UNIT,true); //input을 unit으로 나눔 true니까 구분자로 토큰으로 포함
		
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			int check = NUMBER.indexOf(token); //숫자인지, 단위(UNIT)인지 확인
			
			if(check == -1) { //단위인 경우
				if("만억조".indexOf(token) == -1) {
					tmpResult += (num != 0 ? num : 1) * UNIT_NUM[UNIT.indexOf(token)];
				
				} else { //만억조가 아닌 단위일때
					tmpResult += num;
					result += (tmpResult != 0 ? tmpResult : 1) * UNIT_NUM[UNIT.indexOf(token)];
					tmpResult = 0;
				}
				num = 0;
			} else { //숫자인 경우
				num = check;
			}
		}//end of while
			return result + tmpResult + num;
	}
}
