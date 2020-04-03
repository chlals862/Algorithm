package javaStudy.ch15_입출력Input_Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx3 {
	
	public static void main(String[] args) {
	
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[4];
		
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		System.out.println("Input Source = " + Arrays.toString(inSrc));
		
		try {
			//available() -> 스트림으로부터 ㅇㄺ어 올 수 있는 데이터의 크기를 반환
			while(input.available() > 0) {
				//input.read(temp);
				int len = input.read(temp);
				//output.write(temp);
				output.write(temp, 0, len);
				System.out.println("temp = " + Arrays.toString(temp));
				
				outSrc = output.toByteArray();
				printArrays(temp, outSrc);
			}//while
		} catch (Exception e) {}
	}
	static void printArrays(byte[] temp, byte[] outSrc) {
		System.out.println("Output Source = " + Arrays.toString(outSrc));
		System.out.println("temp          = " + Arrays.toString(temp));
	}
}
