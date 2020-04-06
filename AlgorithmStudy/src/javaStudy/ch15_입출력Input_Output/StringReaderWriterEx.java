package javaStudy.ch15_입출력Input_Output;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.StringWriter;

public class StringReaderWriterEx {
	/*
	 * StringReader/StringWriter -> 입출력 대상이 메모리인 스트림
	 * StringWriter에 출력되는 데이터는 내부의 StringBuffer에 저장됨
	 * 
	 * StringBuffer getBuffer() -> StringWriter에 출력한 데이터가 저장된 StringBuffer를 반환
	 * String toString()        -> StringWriter에 출력된 (StringBuffer에 저장된) 문자열 반환
	 * */
	
	public static void main(String[] args) {
		String inputData = "ABCD";
		
		StringReader input = new StringReader(inputData);
		StringWriter output = new StringWriter();
		
		int data = 0;
		
		
		try {
			while((data = input.read()) != -1) {
				output.write(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Input = " + inputData);
		System.out.println("Output = " + output.toString());
		System.out.println("Output = " + output.getBuffer().toString());
	}
}
