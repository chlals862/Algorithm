package javaStudy.practice;

public class StringBuffer클래스의생성자와메서드 {
	/*
	 * StringBuffer클래스 역시 문자열을 다루기 위한 것이기 때문에
	 * String클래스와 유사한 메서드를 많이 가지고 있음
	 * 그리고 StringBuffer는 추가,변겨,삭제와 같이 저장된 내용을 변경할 수 있는 메서드들이 추가로 제공됨
	 * 
	 * */
	public static void main(String[] args) {
		//StringBuffer() -> StringBuffer sb = new StringBuffer(); 결과 : sb = ""
		StringBuffer sb1 = new StringBuffer();
		System.out.println(sb1);
		
		//StringBuffer(int length) -> StringBuffer sb = new StringBuffer(10);
		//지정된 개수의 문자를 담을 수 이는 버퍼를 가진 StringBuffer인스턴스를 생성함
		StringBuffer sb2 = new StringBuffer(10);
		System.out.println(sb2);
		
		//StringBuffer(String str) -> StringBuffer sb = new StringBuffer("Hi");
		//지정된 문자열 값(str)을 갖는 StringBuffer 인스턴스를 생성함
		StringBuffer sb3 = new StringBuffer("Hi");
		System.out.println(sb3);
		
		//StringBuffer append(boolean,char,char[],double,float,int,long,Object,String..)
		//매개변수로 입력된 값을 문자열로 변환하여 StringBuffer인스턴스가 저장하고 있는 문자열의 뒤에 덧붙임
		StringBuffer sb4 = new StringBuffer("abc");
		StringBuffer sb5 = sb4.append(true);
		sb4.append('d').append(10.0f);
		StringBuffer sb6 = sb4.append("ABC").append(123);
		System.out.println(sb6);
		/* sb4 = "abctrued10.0ABC123"
		 * sb5 = "abctrued10.0ABC123"
		 * sb6 = "abctrued10.0ABC123"
		 * */
		
		//int capacity() -> StringBuffer인스턴스의 버퍼크기를 알려줌
		//length()는 버퍼에 담긴 문자열의 길이를 알려줌
		StringBuffer sb7 = new StringBuffer(100);
		sb7.append("abcd");
		int bufferSize = sb7.capacity();
		int stringSize = sb7.length();
		System.out.println("sb7.capacity() = " + bufferSize); //100
		System.out.println("sb7.length() = " + stringSize); //4 -> "abcd"
		
		//char charAt(int index) -> 지정된 위치(index)에 있는 문자를 반환
		StringBuffer sb8 = new StringBuffer("ABCDE");
		char c = sb8.charAt(4); //index는 0부터
		System.out.println(c);
		
		//StringBuffer delete(int start,int end)
		//시작위치(start)부터 끝 위치(end) 사이에 있는 문자를 제거 ★★★단,끝 위치의 문자는 제외★★★
		StringBuffer sb9 = new StringBuffer("1234567890");
		StringBuffer sb10 = sb9.delete(2,5);//3부터~6(끝위치제외) -> 3~5까지 제외
		System.out.println(sb10);
		
		//StringBuffer deleteCharAt(int index)
		//지정된 위치(index)의 문자를 제거함
		StringBuffer sb11 = new StringBuffer("12345");
		sb11.deleteCharAt(3); //index 3의 위치[4]를 제거 -> 1235
		System.out.println(sb11);
		
		/* StringBuffer inssert(int pos, boolean,char...)
		 * 두 번째 매개변수로 받은 값을 문자열로 변환하여 지정된 위치(pos)에 추가함,pos는 0부터 시작
		 * */
		StringBuffer sb12 = new StringBuffer("0123456");
		sb12.insert(2, '/'); //pos 2번위치(2)에다가 '/' 삽입 -> 01/23456
		System.out.println(sb12);
		
		//StringBuffer replace(int start,int end, String str)
		//지정된 범위(start~end)의 문자들을 주어진 문자열로 바꿈
		//end위치의 문자는 범위에 포함 되지 않음 (start <= x < end)
		StringBuffer sb13 = new StringBuffer("ABCD0123");
		sb13.replace(2, 5, "!@#$"); //start(2)번위치(C)부터 end(5)번위치(0)[1은 5번이지만 포함x]의 문자열들을 "!@#$"로변경
		System.out.println(sb13); //AB!@#$123
		
		//StringBuffer reverse() -> StringBuffer인스턴스에 저장되어 있는 문자열의 순서를 거꾸로 나열
		StringBuffer sb14 = new StringBuffer("ABCD1234");
		sb14.reverse();
		System.out.println(sb14); //->4321DCBA
		
		//void setCharAt(int index, char ch)
		//지정된 위치의 문자를 주어진 문자(ch)로 바꿈
		StringBuffer sb15 = new StringBuffer("0123456");
		sb15.setCharAt(5, 'o'); //->index5번자리(5)대신 'o'삽입
		System.out.println(sb15);
		
		//void setLength(int newLength)
		//지정된 길이로 문자열의 길이를 변경함. 길이를 늘리는 경우에 나머지 빈 공간을 널문자 '\u0000'로 채움
		StringBuffer sb16 = new StringBuffer("0123456789");
		sb16.setLength(5);
		System.out.println(sb16); // -> 01234 
		StringBuffer sb17 = new StringBuffer("0123456789");
		sb17.setLength(8);
		String str = sb17.toString().trim();
		System.out.println(str);
		
		//String toString() -> StringBuffer인스턴스의 문자열을 String으로 반환
		StringBuffer sb18 = new StringBuffer("ABCDEFG");
		String str2 = sb18.toString();
		System.out.println(str2);
		
	}
}
