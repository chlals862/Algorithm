package javaStudy.ch06_객체지향프로그래밍l;

public class BlockTest_클래스_인스턴스_초기화블럭 {
	/*
	 * 클래스 초기화 블럭 -> 클래스 변수의 복잡한 초기화에 사용
	 * 인스턴스 초기화 블럭 -> 인스턴스 변수의 복잡한 초기화에 사용
	 * ===========================================
	 * 클래스 초기화 블럭은 클래스가 메모리에 처음 로딩될 때 한번만 수행
	 * 인스턴스 초기화 블럭은 생성자와 같이 인스턴스를 생성할 때 마다 수행
	 * 
	 * 생성자 보다 인스턴스 초기화 블럭이 먼저 수행 됨
	 * */
	static {
		System.out.println("static { }");   //10~12 Line은 클래스 초기화 블럭
	}
	
	{ 
		System.out.println("{ }");	//14~16 Line은 인스턴스 초기화 블럭
	}
	
	public BlockTest_클래스_인스턴스_초기화블럭() {
		System.out.println("생성자");
	}
	
	
	public static void main(String[] args) {
		System.out.println("BlockTest bt = new BlockTest();");
		BlockTest_클래스_인스턴스_초기화블럭 bt = new BlockTest_클래스_인스턴스_초기화블럭();
		
		System.out.println("BlockTest bt2 = new BlockTest();");
		BlockTest_클래스_인스턴스_초기화블럭 b2 = new BlockTest_클래스_인스턴스_초기화블럭();
	}
	//클래스 초기화 블럭이 가장 먼저 수행 -> static { }
	//main메서드가 수행되어 BlockTest인스턴스가 생성되면서 인스턴스 초기화 블럭이 먼저 수행됨
	//끝으로 생성자가 수행 
	//인스턴스 초기화 블럭은 인스턴스가 생성될 떄 마다 수행 한다는것을  알아두기
}
