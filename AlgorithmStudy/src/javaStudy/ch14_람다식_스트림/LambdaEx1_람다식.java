package javaStudy.ch14_람다식_스트림;
	/*
	 * 람다식 -> 메서드를 하나의 식으로 표현한 것
	 * 함수를 간략하면서도 명확한 식으로 표현할 수 있게 해줌
	 * 람다식 == 익명함수★★★★★라고도 함
	 * 
	 * */
@FunctionalInterface
interface MyFunction {
	void run(); //public abstarct void run();
}

public class LambdaEx1_람다식 {
	static void execute(MyFunction f) { //매개벼수의 타입이 MyFunction인 메서드
		f.run();
	}
	
	static MyFunction getMyFuntion() { //반환 타입이 MyFunction인 메서드
		MyFunction f = () -> System.out.println("f3.run()");
		
		return f;
	}
	
	public static void main(String[] args) {
		//람다식으로 MyFunction의 run()을 구현
		MyFunction f1 = () -> System.out.println("f1.run()");
		
		MyFunction f2 = new MyFunction() { //익명클래스로 run()을 구현
			public void run() { //public을 반드시 붙여야 함
				System.out.println("f2.run()");
			}
		};
		MyFunction f3 = getMyFuntion();
		
		f1.run();
		f2.run();
		f3.run();
		
		execute(f1);
		execute( () -> System.out.println("run()") );
	}
	
	
}
