package javaStudy.ch6_객체지향프로그래밍l;

class Data3 { //다른 클래스의 Data를 사용가능 하지만, 없다는 가정하에 Data3로 선언[중복불가]
	int x;
}
public class ReferenceReturnEx_참조형반환타입 {
	/*
	 * copy메서드 내에서 생성한 객체를 main메서드에서 사용할 수 있으려면
	 * ★★★새로운 객체의 주소를 반환해줘야 함★★★
	 * 그렇지 않으면 copy메서드가 종료되면서 새로운 객체의 참조가 사라지기 때문에 
	 * 더 이상 이 객체를 사용할 수가 없음
	 * copy메서드가 호출된 직후부터 종료까지의 과정은 p269참조
	 * */
	public static void main(String[] args) {
		Data3 d = new Data3();
		d.x = 10;
		
		//이 메서드의 반환 타입이 Data3이므로 호출결과를 저장하는 변수의 타입 역시 Data3타입의 참조변수여야함
		Data3 d2 = copy(d);	//static Data3 copy(Data3 d)
		System.out.println("d.x = " + d.x);
		System.out.println("d2.x = " + d2.x);
	}
	
	static Data3 copy(Data3 d) { //새로운 객체 생성 및 매개변수로 넘겨받은 객체에 저장된 값을 복사해서 반환
		Data3 tmp = new Data3(); //반환하는 값이 Data3객체의 주소이므로 반환 타입이 Data3임0
		tmp.x = d.x; //d.x의 값을 tmp.x에 복사
		
		return tmp; //복사한 객체의 주소 반환
	}
}
