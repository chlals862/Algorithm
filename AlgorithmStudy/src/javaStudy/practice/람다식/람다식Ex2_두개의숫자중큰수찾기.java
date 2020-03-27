package javaStudy.practice.람다식;

public class 람다식Ex2_두개의숫자중큰수찾기 {

	@FunctionalInterface //함수형 인터페이스 체크 어노테이션
	public interface MyNumber {
		int getMax(int num1, int num2);
	}
	
	public static void main(String[] args) {
		MyNumber max = (x,y)-> (x>=y) ? x : y; //x가 y보다 크거나 같을 때 x / 아닐땐 y
		System.out.println(max.getMax(10, 30));
	}
}
