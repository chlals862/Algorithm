package javaStudy.Practice;

public class String클래스의생성자와메서드 {

	public static void main(String[] args) {
		//String(String s) -> 주어진 문자열(s1)을 갖는 String 인스턴스를 생성
		String s1 = new String("MinHo");
		System.out.println(s1);
		
		//String(char[] value) -> 주어진 문자열(value)을 갖는 String인스턴스를 생성
		char[] c = {'H','E','L','L','O'};
		String s2 = new String(c);
		System.out.println(s2);
		
		//String(StringBuffer buf) -> StringBuffer인스턴스가 갖고 있는 문자열과 같은 내용의 String인스턴스를 생성
		StringBuffer sb1 = new StringBuffer("NiceToMeetYou");
		String s3 = new String(sb1);
		System.out.println(s3);
		
		//char charAt(int index) -> 지정된 위치(index)에 있는 문자를 알려줌
		String s = "Hello";
		String n = "0123456";
		char c1 = s.charAt(1);
		char c2 = n.charAt(1);
		System.out.println("c1 = " + c1 + "  c2 = " + c2);
		
		//int compareTo(String str) -> 문자열(str)과 사전순서로 비교 같으면 0,사전순으로 이전이면 음수,이후면 양수 반환
		int i1 = "aaa".compareTo("aaa");
		int i2 = "aaa".compareTo("bbb");
		int i3 = "bbb".compareTo("aaa");
		System.out.println("i1 = " + i1 + "  i2 = " + i2 + "  i3 = " + i3);
		
		//String concat(String str) -> 문자열(str)을 뒤에 덧붙임
		String s4 = "Hello";
		String s5 = s4.concat(" World");
		System.out.println(s5);
		
		//boolean contains(CharSequence s) -> 지정된 문자열(s)이 포함되었는지 검사  true/false
		String s6 = "abcdefgh";
		boolean b1 = s6.contains("fg");
		System.out.println(b1);
		
		//boolean endsWith(String suffix) -> 지정된 문자열(suffix)로 끝나는지 검사 true/false
		String file1 = "Hello.jpeg";
		boolean b2 = file1.endsWith("eg");
		System.out.println(b2);
		
		//boolean equals(Object obj) -> 매개변수로 받은 문자열(obj)과 String인스턴스의 문자열을 비교
		//obj가 String이 아니거나 문자열이 다르면 false를 반환
		String s7 = "Hello";
		boolean b3 = s7.equals("Hello"); //대소문자 따짐
		boolean b4 = s7.equalsIgnoreCase("heLlO"); //대소문자 무시
		System.out.println("b3 = " + b3 + "  b4 = " + b4);
		
		//int indexOf(int ch) -> 주어진 문자(ch)까 문자열에 존재하는지 확인하여 위치(index)를 알려줌
		//못 찾으면 -1을 반환(index는 0부터 시작)
		String s8 = "Hello World";
		int idx1 = s8.indexOf('o');
		int idx2 = s8.indexOf('Z');
		System.out.println("idx1 = " + idx1 + "  idx2 = " + idx2);
		
		//int indexOf(int ch, int pos) -> 주어진 문자(ch)가 문자열에 존재하는지 지정된 위치(pos)부터 확인하여
		//위치(index)를 알려줌, 못 찾으면 -1을 반환
		System.out.println("=================================");
		String s9 = "Hello World";
		int idx3 = s9.indexOf('e', 0); //0번째 위치부터 e를 검사 -> 결과 1
		int idx4 = s9.indexOf('d', 6); //6번째 위치(W)부터 d를 검사 -> 결과10
		System.out.println("idx3 = " + idx3 + "  idx4 = " + idx4);
		
		//int indexOf(String str) -> 주어진 문자열이 존재하는지 확인하여 그 위치(index)를 알려줌
		//없으면 -1을 반환
		String s10 = "Minho";
		int idx5 = s10.indexOf("ho");
		System.out.println(idx5);//h의 위치 [3]
		
		//String intern() -> 문자열을 상수풀(constant pool)에 등록함
		//이미 상수풀에 같은 내용의 문자열이 있을 경우 그 문자열의 주소값을 반환
		String s11 = new String("abc");
		String s12 = new String("abc");
		boolean b5 = (s11==s12);
		boolean b6 = s11.equals(s12);
		boolean b7 = (s11.intern() == s12.intern());
		System.out.println("s11 = " + s11 + "  s12 = " + s12 + "  b5 = " + b5 + "  b6 = " + b6 + "  b7  = " + b7);
		
		//int lastIndexOf(int ch) -> 지정된 문자 또는 문자코드를 문자열의 오른쪽 끝에서부터 찾아서 위치를 알려줌, 못 찾으면 -1 반환
		//String형도 가능
		String s13 = "java.lang.Object";
		int idx6 = s13.lastIndexOf('.');
		int idx7 = s13.indexOf('.');
		System.out.println("idx6 = " + idx6);//뒤에있는
		System.out.println("idx7 = " + idx7);//앞에있는
		
		//int length() -> 문자열길이
		String s14 = "Hello World!!";
		System.out.println(s14.length());
		
		//String replace(char old, char nw) -> 문자열 중의 문자(old)를 새로운 문자 (nw)로 바꾼 문자열을 반환
		String s15 = "Hello";
		String s16 = s15.replace('H', 'C');
		System.out.println(s16);
		
		//String replaceAll(String regex, String replacement) -> 
		//문자열 중에서 지정된 문자열과 일치하는 것을 새로운 문자열로 모두 변경
		String ab = "AABBAABB";
		String r = ab.replace("BB", "bb");
		System.out.println(r);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
