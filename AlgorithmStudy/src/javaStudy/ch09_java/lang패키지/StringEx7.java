package javaStudy.ch09_java.lang패키지;

public class StringEx7 {

	public static void main(String[] args) {
		
		String fullName = "Hello.java";
		//fulName에서 '.'의 위치를 찾는다.
		int index = fullName.indexOf('.');
		
		//fullName의 첫번째 글자부터 '.'가 있는 자리까지 찾음
		String fileName = fullName.substring(0,index);
		//'.'의 다음 문자부터 시작해서 문자열 끝까지 추적
		//fullName.substring(index+1,fullName.length());의 결과와 같음
		
		String ext = fullName.substring(index+1);
		
		System.out.println(fullName + "의 확장자를 제외한 이름은 " + fileName);
		System.out.println(fullName + "의 확장자는 " + ext);
	}
}
