package javaStudy.ch15_입출력Input_Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

public class SequenceInputStreamEx1 {
	/*
	 * SequenceInputStream -> 여러 개의 입력스트림을 연속적으로 연결
	 *                     -> 하나의 스트림으로부터 데이터를 읽는 것과 같이 처리할 수 있도록 도와줌
	 * -------------------------------------------------------------------
	 * 큰 파일을 여러 개의 작은 파일로 나누었다가 하나의 파일로 합치는 것과 같은 작업을 수행할 때 사용
	 * */
	
	public static void main(String[] args) {
		byte[] arr1 = {0,1,2};
		byte[] arr2 = {3,4,5};
		byte[] arr3 = {6,7,8};
	
		byte[] outSrc = null;
		
		Vector v = new Vector();
		v.add(new ByteArrayInputStream(arr1));
		v.add(new ByteArrayInputStream(arr2));
		v.add(new ByteArrayInputStream(arr3));
		
		SequenceInputStream input = new SequenceInputStream(v.elements());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		int data = 0;
		
		try {
			while((data = input.read()) != -1) {
				output.write(data); //void write(int b)
			}
		} catch (Exception e) {}
	
		outSrc = output.toByteArray();
		
		System.out.println("Input Source1 = " + Arrays.toString(arr1));
		System.out.println("Input Source2 = " + Arrays.toString(arr2));
		System.out.println("Input Source3 = " + Arrays.toString(arr3));
		System.out.println("Output Source = " + Arrays.toString(outSrc));
	}
}
