package javaStudy.ch15_입출력Input_Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx1 {
	/*
	 * 바이트기반 스트림
	 * 스트림은 바이트단위로 데이터를 전송하며 입출력 대상에 따라 입출력스트림이 있음
	 * */
	public static void main(String[] args) {
		/*
		 * ByteArrayInputStream/ByteArrayOutputStream을 이용해서 
		 * 바이트배열 inSrc의 데이터를 outSrc로 복사하는 예제
		 * 
		 * */
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		int data = 0;
		
		
		/* while문 조건식 순서
		 * (data = input.read()) != -1
		 * 1. data = input.read() -> read()를 호출한 반환값을 변수 data에 저장 (괄호먼저)
		 * 2. data != -1          -> data에 저장된 값이 -1이 아닌지 비교
		 * 바이트배열은 사용하는 자원이 메모리 밖에 없으므로 가비지컬렉터에 의해 자동적으로 자원을 반환하므로 close()를 이용해서 스트림을 닫지 않아도 됨
		 * */
		while((data = input.read()) != -1) {
			output.write(data); //void write(int b)
 		}
		
		outSrc = output.toByteArray(); //스트림의 내용을 byte배열로 반환
		
		System.out.println("Input Source = " + Arrays.toString(inSrc));
		System.out.println("Output Source = " + Arrays.toString(outSrc));
		
	}
}
