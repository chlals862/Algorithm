package javaStudy.ch7_객체지향프로그래밍II;

	/*	상속 -> 기존의 클래스를 재사용하여 새로운 클래스를 작성하는 것
	 *  장점 -> 보다 적은양의 코드로 새로운 클래스를 작성할 수 있고 코드를 공통적으로 관리할 수 있기 때문에 코드의 추가 및 변경이 매우 용이
	 *  
	 *  상속 구현 -> 새로 작성하고자 하는 클래스의 이름 뒤에 상속받고자 하는 클래스의 이름을 키워드 'extends'와 함꼐 써주면 됨
	 * 	ex) class Child extends parent 
	 *  -> Child는 새로 작성하려는 클래스
	 *  -> Parent는 상속받고자 하는 기존 클래스
	 * 
	 *  상속은 생성자와 초기화 블럭은 상속되지 않고 멤버변수만 상속됨
	 *  자손 클래스의 멤버 개수는 조상 클래스보다 항상 같거나 많음
	 * */
class Tv {
	boolean power; //전원상태[on/off]
	int channel; 
	
	void power() {
		power = !power;
	}
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
}
class CaptionTv extends Tv {
	boolean caption; //캡션상태 [on/off]
	
	void displayCaption(String text) {
		if(caption) { //캡션상태가 on(True)일 때만 text를 보여 줌
			System.out.println(text);
		}//if of end
	}
}

public class CaptionTvTest_상속 {

	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10; //조상 클래스로부터 상속받은 멤버
		ctv.channelUp();  //조상 클래스로부터 상속받은 멤버
		System.out.println(ctv.channel);
		
		ctv.displayCaption("Hello Java"); 
		ctv.caption = true; //캡션[자막]기능을 킴 / //boolean형의 기본형은 false이므로 true일때만 text가 출력되므로 caption을 true로 변경해줌
		ctv.displayCaption("Hello World"); //caption이 true이므로 Hello World가 출력 됨
	} //자손 클래스의 인스턴스를 생성하면 조상 클래스의 멤버와 자손 클래스의 멤버가 합쳐진 하나의 인스턴스로 생성됨
}
