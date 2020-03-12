package javaStudy.ch09_java.lang패키지;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalEx {
	/*
	 * 정수 X 10의 -scale승
	 * scale은 0부터 Integer.MAX_VALUE사이의 범위에 있는 값
	 * 
	 * EX) 123.45 -> 12345X10 -2승 
	 * value -> 12345 scale -> 2 
	 * scale -> 소수점 이하의 자리수
	 * precision -> 정수의 전체 자리수
	 * 
	 * */
	public static void main(String[] args) throws Exception{
		BigDecimal bd1 = new BigDecimal("123.456");
		BigDecimal bd2 = new BigDecimal("1.0");

		System.out.print("bd1="+bd1);
		System.out.print(",\tvalue="+bd1.unscaledValue());
		System.out.print(",\tscale="+bd1.scale());
		System.out.print(",\tprecision="+bd1.precision());
		System.out.println();
		
		System.out.print("bd2="+bd2);
		System.out.print(",\tvalue="+bd2.unscaledValue());
		System.out.print(",\tscale="+bd2.scale());
		System.out.print(",\tprecision="+bd2.precision());
		System.out.println();
		
		BigDecimal bd3 = bd1.multiply(bd2);
		System.out.print("bd3="+bd3);
		System.out.print(",\tvalue="+bd3.unscaledValue());
		System.out.print(",\tscale="+bd3.scale());
		System.out.print(",\tprecision="+bd3.precision());
		System.out.println();
	
		System.out.println(bd1.divide(bd2, 2, RoundingMode.HALF_UP)); //123.46
		System.out.println(bd1.setScale(2, RoundingMode.HALF_UP)); // 123.46
		System.out.println(bd1.divide(bd2, new MathContext(2, RoundingMode.HALF_UP)));
	}
	
}
