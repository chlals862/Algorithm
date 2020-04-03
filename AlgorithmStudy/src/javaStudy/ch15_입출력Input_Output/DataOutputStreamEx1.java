package javaStudy.ch15_입출력Input_Output;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.Arrays;

public class DataOutputStreamEx1 {
	/*
	 * 데이터를 읽고 쓰는데 있어서 byte단위가 아닌, 8가지 기본 자료형의 단위로 읽고 쓸 수 있다는 장점이 있음
	 * ex) int값을 출력 -> 4byte의 16진수로 출력
	 * ---------------------------------
	 * 각 자료형의 크기가 다르므로, 출력한 데이터를 다시 읽어 올 때는 출력했을 때의 순서를 염두에 두어야 함★★★★★
	 * 
	 * */
	
	public static void main(String[] args) {
		ByteArrayOutputStream bos = null;
		DataOutputStream dos = null;
		
		byte[] result = null;
		
		try {
			bos = new ByteArrayOutputStream();
			dos = new DataOutputStream(bos);
			
			dos.writeInt(10); //4byte인 0,0,0,10 는 write(10)에 의해 출력
			dos.writeFloat(20.0f);//1byte인 1은 writeBoolean(true)에 의해 출력
			dos.writeBoolean(true);
			
			result = bos.toByteArray();
			
			String[] hex = new String[result.length];
			
			for(int i=0; i<result.length;i++) {
				if(result[i] < 0) {
					hex[i] = String.format("%02x", result[i]+256);
				} else {
					hex[i] = String.format("%02x", result[i]);
				}//else
			}//for
			
			System.out.println("10진수 = " + Arrays.toString(result)); //0,0,0,10,65,-96,0,0,1
			System.out.println("16진수 = " + Arrays.toString(hex));
			
			dos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
