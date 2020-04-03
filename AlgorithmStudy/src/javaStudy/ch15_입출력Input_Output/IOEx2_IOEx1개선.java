package javaStudy.ch15_입출력Input_Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx2_IOEx1개선 {
	/*
	 * IOEx1의 입출력 작업을 보다 효율적으로 이루어지도록 한 예제
	 * */
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[10];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		//void write(byte[] b, int off, int len) -> 주어진 배열 b에 저장된 내용 중에서 off번째부터 len개 만큼만을 읽어서 출력소스에 
		input.read(temp, 0, temp.length); //읽어 온 데이터를 배열 temp에 담음
		output.write(temp, 5, 5); //temp[5]부터 5개의 데이터를 write함
		
		outSrc = output.toByteArray();
		
		System.out.println("Input Source = " + Arrays.toString(inSrc));
		System.out.println("Temp         = " + Arrays.toString(temp));
		System.out.println("Output Source = " + Arrays.toString(outSrc));
	}
}
