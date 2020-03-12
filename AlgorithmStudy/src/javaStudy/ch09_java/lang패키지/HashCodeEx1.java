package javaStudy.ch09_java.lang패키지;

public class HashCodeEx1 {
	/* 해시코드 -> int타입의 정수
	 * hashCode() -> 해싱기법에 사용되는 해시함수를 구현한 것
	 * 다량의 데이터를 저장하고 검색하는 데 유용함
	 * 
	 * 해시함수는 찾고자하는 값을 입력하면 그 값이 저장된 위치를 알려주는 해시코드를 반환함
	 * 
	 * */
	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		
		System.out.println(str1.equals(str2));

		//String클래스는 문자열의 내용이 같으면, 동일한 해시코드를 반환하도록 hashCode메서드가 오버라이딩되어 있기 때문에,
		//문자열의 내용이 같은 str1,str2에 대해 hashCode()를 호출하면 ㅎㅇ상 동일한 해시코드값을 얻음
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
		
		//System.identityHashCode(Object x)는 Object 클래스의 hashCode메서드처럼 
		//객체의 주소값으로 해시코드를 생성하기 때문에 모든 객체에 대해 항상 다른 해시코드값을 반환할 것을 보장함
		//그래서 str1과 str2가 해시코드는 같지만 서로 다르 객체라는것을 알 수 있음
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
	}
}
