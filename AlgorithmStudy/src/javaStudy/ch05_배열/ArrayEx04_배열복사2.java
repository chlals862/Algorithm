package javaStudy.ch05_배열;

public class ArrayEx04_배열복사2 {

	/*
	 * System.arraycopy()를 이용한 배열복사 ->보다 간단하고 빠르게 배열 복사법
	 * for문은 배열의 요소 하나하나에 접근해서 복사하지만,
	 * arraycopy()는 지정된 범위의 값들을 한 번에 통째로 복사
	 * 
	    * ★★★★★★★★★★★★char배열은 for문을 사용하지 않고 print()나 println()으로 배열에 저장된 모든 문자를 출력
	 *    
	 *  array(Object src,int srcPos, object dest,int destPos, length)
	 *  Object src = 배열 원본
	 *  srcPos = 소스 배열을 어디부터 복사시킬 것인지
	 *  dest = 위치시킬 배열
	 *  destPos = 위치시킬 배열의 시작 데이터 위치
	 *  length =  복사되는 배열 요소의 수 
	 * */
	public static void main(String[] args) {
		
		char[] abc = {'A','B','C','D'};
		char[] num = {'0','1','2','3','4','5','6','7','8','9'};
		
		System.out.println(abc);
		System.out.println(num);
		
		//배열 abc와 num을 붙여서 하나의 배열(result)로 만듦
		char[] result = new char[abc.length+num.length];
		
		System.arraycopy(abc, 0, result, 0, abc.length);
		//num[0]에서    result[0]으로 abc.length개의 데이터를 복사
		System.arraycopy(num, 0, result, abc.length, num.length);
		//num[0]에서 result의[abc배열의 길이만큼] num.length개의 데이터를 복사
		System.out.println(result); //결과값 : ABCD0123456789
		
		//배열 abc을 배열 num의 첫 번째 위치부터 배열 abc의 길이만큼 복사
		System.arraycopy(abc, 0, num, 0, abc.length);
		System.out.println(num); //ABCD456789
		
		System.arraycopy(abc, 0, num, 6, 3);
		//abc[0]에서 num[6]으로 3개의 데이터를 복사 -> 위 결과 ABCD456789 에서 6번쨰 인덱스인 ABCD45[6]에서 3개 복사 [ABC]
		System.out.println(num);//결과값 ABCD45 ABC 9
		
	}
}
