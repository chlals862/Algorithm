package javaStudy.ch12_제너릭스_열거형_어노테이션;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.Annotation;

@Deprecated
@SuppressWarnings("1111") //유효하지 않은 애너테이션은 무시
//@TestInfo(testedBy="aaa", testDate=@DateTime(yymmdd="1600101", hhmmss="235959"))
class AnnotationEx5 {
	public static void main(String[] args) {
		//AnnotationEx5의 Class객체를 얻음
		
		Class<AnnotationEx5> cls = AnnotationEx5.class;
		
		TestInfo anno = (TestInfo)cls.getAnnotation(TestInfo.class);
		System.out.println("anno.testedBy() = " + anno.testedBy());
		System.out.println("anno.testDate().yymmdd = " + anno.testDate().yymmdd());
		System.out.println("anno.testDate().hhmmss = " + anno.testDate().hhmmss());
		
		for(String str : anno.testTools()) 
			System.out.println("testTools = " + str);
	
		System.out.println();
		//AnnotationEx5에 적용된 모든 어노테이션을 가져옴
		Annotation[] annoArr = (Annotation[]) cls.getAnnotations();
		
		for(Annotation a : annoArr)
			System.out.println(a);
	
	}
}

@Retention(RetentionPolicy.RUNTIME) //실행 시에 사용가능하도록 지정
@interface TestInfo {
	int count() default 1;
	String testedBy();
	String[] testTools(); // default -> "JUnit"
	TestType testType(); //  default -> TestType.FIRST;
	DateTime testDate();
}

@Retention(RetentionPolicy.RUNTIME)
@interface DateTime {
	String yymmdd();
	String hhmmss();
}
enum TestType { FIRST, FINAL }