package javaStudy.ch11_컬렉션프레임웍;

import java.util.Properties;

public class PropertiesEx4 {

	/* Properties -> HashMap의 구버전인 Hashtable을 상속받아 구현함
	 * Properties는 (String,String)의 형태로 저장하는 단순화된 컬렉션 클래스
	 * 시스템속성을 보여주는 예제
	 * */
	public static void main(String[] args) {
		Properties sysProp = System.getProperties();
		System.out.println("java.version = " + sysProp.getProperty("java.version"));
		System.out.println("user.language = " + sysProp.getProperty("user.language"));
		
		sysProp.list(System.out);
	}
}
