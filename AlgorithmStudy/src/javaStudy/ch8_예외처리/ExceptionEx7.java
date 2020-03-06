package javaStudy.ch8_예외처리;

public class ExceptionEx7 {
	/*
	 * 예외처리의 정의 -> 프로그램 실행 시 발생할 수 있는 예외에 대비한 코드를 작성
	 * 예외처리의 목적 -> 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지
	 * 
	 * */
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0);
			System.out.println(4);
		} catch (ArithmeticException ae) {
			if(ae instanceof ArithmeticException)
				System.out.println("true");
			System.out.println("ArithmeticException");
		} catch (Exception e ) {
			System.out.println("Exception");
		}//try-catch of end 
		System.out.println(6);
	}
}
