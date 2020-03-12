package javaStudy.ch09_java.lang패키지;

import java.util.StringTokenizer;

public class StringTokenizerEx5 {
	/*	구분자를 ','로 하는 문자열 데이터를 split()과 StringTokenizer로 잘라낸 결과를 비교하는 예제
	 * 
	 * split()은 빈 문자열도 토큰으로 인식하는 반면 
	 * StringTokenizer는 빈 문자열을 토큰으로 인식하지 않기 때문에 인식하는 토큰의 개수가 서로 다름
	 * */
	public static void main(String[] args) {
		String data = "100,,,200,300";
		
		String[] result = data.split(",");
		StringTokenizer st = new StringTokenizer(data,",");
		
		for(int i=0;i<result.length;i++)
			System.out.print(result[i]+"|");
		
		System.out.println("개수 : " + result.length + " <- split()");
		
		int i = 0;
		
		for(;st.hasMoreTokens();i++)
			System.out.print(st.nextToken()+"|");
			
			System.out.println("개수 : " + i + " <- StringTokenizer");
	}
}
