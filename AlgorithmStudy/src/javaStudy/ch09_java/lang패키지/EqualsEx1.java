package javaStudy.ch09_java.lang패키지;

public class EqualsEx1 {
	/*
	 * equals메서드를 이용해서 두 인스턴스 비교
	 * equals메서드는 주소값으로 비교를 하기 때문에,
	 * 두 Value인스턴의 멤버변수 value의 값이 10으로 서로 같을지라도
	 * equals메서드로 비교한 결과는 false일 수밖에 없음
	 * */
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		if(v1.equals(v2))
			System.out.println("v1과 v2는 같음");
		else
			System.out.println("v1과 v2는 다름");
		//false
		v2 = v1; //v2 = v1; 수행후 참조변수v2는 v1이 참조하고 있는 인스턴스의 주소값이 저장되므로 v2도 v1과 가은 주소값이 저장됨
		
		if (v1.equals(v2))
			System.out.println("v1과 v2는 같음");
		else
			System.out.println("v1과 v2는 다름");
		//true
	}  
}

class Value {
	int value;
	
	Value(int value) {
		this.value = value;
	}
}