package javaStudy.ch12_제너릭스_열거형_어노테이션;

import java.util.ArrayList;

/* 어노테이션 -> 프로그램의 소스코드 안에서 다른 프로그램을 위한 정보를 미리 약속된 형식으로 포함시킨 것
 *        -> 주석처럼 프로그래밍 언어에 영향을 미치지 않으면서, 다른 프로그램에게 유용한 정보를 제공할 수 있다는 장점을 갖고 있음
	 * @override -> 메서드 앞에만 붙일 수 있는 어노테이션
	 *          -> 조상의 메서드를 오버라디이하는 것이라는걸 컴파일러에게 알려주는 역할
	 * @deprecated -> 더 이상 사용되지 않는 필드나 메서드에 사용
	 * @functionalinterface -> 함수형 인터페이스를 선언할 때 사용
	 *                      -> 함수형 인터페이스를 올바르게 선언했는지 확인
	 *                      -> 잘못된 경우 에러를 발생시킴
	 * */
class NewClass {
	
	int newField;
	
	int getNewField() {
		return newField;
	}
		@Deprecated
		int oldField;
		
		@Deprecated
		int getoldField() {
			return oldField;
		}
}
public class AnnotationEx3_어노테이션 {
	@SuppressWarnings("deprecation") //deprecation관련 경고 억제
	public static void main(String[] args) {
		NewClass nc = new NewClass();
		
		nc.oldField = 10; //@Deprecated가 붙은 대상을 사용
		System.out.println(nc.getoldField()); //@Deprecated가 붙은 대상을 사용
		
		@SuppressWarnings("unchecked") //제너릭스 관련 경고 억제
		ArrayList<NewClass> list = new ArrayList(); //타입을 지정하지 않음
		list.add(nc);
		
	}
}
