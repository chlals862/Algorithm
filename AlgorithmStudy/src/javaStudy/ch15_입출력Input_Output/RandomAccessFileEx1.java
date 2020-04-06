package javaStudy.ch15_입출력Input_Output;

import java.io.RandomAccessFile;

public class RandomAccessFileEx1 {
	/*
	 * RandomAccessFile -> 파일의 어느 위치에나 읽기/쓰기 가능
	 * */
	
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
			//파일에 출력작업이 수행되었을 때 파일 포인터의 위치가 어떻게 달라지는지에 대한 예제
			System.out.println("파일 포인터의 위치 = " + raf.getFilePointer()); //0
			raf.writeInt(100);
			//int가 4byte이기 때문에 writeInt()를 호출한 다음 파일 포인터의 위치가 0 -> 4로 바뀜
			System.out.println("파일 포인터의 위치 = " + raf.getFilePointer()); //4
			raf.writeLong(100L);
			//8byte인 ong을 출력하는 writeLong()을 호출한 후에는 파일 포인터의 위치가 4 -> 12로 바뀜
			System.out.println("파일 포인터의 위치 = " + raf.getFilePointer()); //12
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
}
