package javaStudy.ch15_입출력Input_Output;

import java.io.EOFException;
import java.io.RandomAccessFile;

public class RandomAccessFileEx2 {
	public static void main(String[] args) {
		
				// 번호,국어, 영어, 수학
	int[] score = {	1, 100, 90, 90,
					2,	70,	90,	100,
					3,	100,100,100,
					4,	70,	60,	80,
					5,	70,	90,	100
	};
	
		try {
			RandomAccessFile raf = new RandomAccessFile("score2.dat", "rw");
			for (int i = 0; i < score.length; i++) {
				raf.writeInt(score[i]);
			} // for
			//raf.seek를 호출하지 않으면 아무것도 뜨지 않음
			//writeInt()를 ㅎ수행하면서 파일 포인터의 위치가 파일의 마지막으로 이동되었기 때문
			//그 다음에 readInt()를 호출했으므로 파일의 앞부분이 아닌 마지막 부분부터 읽기 시작하기 때문에 아무것도 읽지못하고 EOF익셉션 발생해서 무한반복문을 벗어나게 됨
			raf.seek(0);//seek(long pos)를 이용해서 파일포인터의 위치를 다시 처음으로 이동시킨다음 readInt()를 호출 해야함
			while (true) {
				System.out.println(raf.readInt());
			}

		} catch (EOFException eof) {
			// readInt()를 호출했을 때 더 이상 읽을 내용이 없으면 exception발생
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
