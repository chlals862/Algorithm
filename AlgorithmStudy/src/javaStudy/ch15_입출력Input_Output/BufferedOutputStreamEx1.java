package javaStudy.ch15_입출력Input_Output;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamEx1 {
	/* 
	 * BufferedInputStream/BufferedOutputStream ★★★★★
	 * 스트림의 입출력 효율을 높이기 위해 버퍼를 사용하는 보조스트림
	 * 한 바이트씩 입출력하는 것 보다는 버퍼(바이트배열)를 이용해서 한 번에 여러 바이트를 입출력하는 것이 빠르기 떄문에
	 * 대부분의 입출력 작업에 사용됨
	 * 
	 * BufferedOutputStream의 생성자와 메서드
	 * flush() -> 버퍼의 모든 내용을 출력소스에 출력한 다음, 버퍼를 비움
	 * close() -> flush()를 호출해서 버퍼의 모든 내용을 출력소스에 출력하고,
	 * BufferedOutputStream인스턴스가 사용하던 모든 자원을 반환
	 * ====================================================
	 * 버퍼가 가득 찼을 때만 출력소스에 출력을 하기 때문에★★★★★
	 * 마지막 출력부분이 출력소스에 쓰이지 못하고 BufferedOutputStream의 버퍼에 남아 있는 채로 프로그램이 종료될 수 있음
	 * 그래서 close()나 flush()를 호출해서 마지막에 버퍼에 있는 모든 내용이 출력소스에 출력되도록 해야 함 ★★★★★
	 * */
	
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("123.txt");
			//BufferedOutputStream의 버퍼 크기를 5로 설정
			BufferedOutputStream bos = new BufferedOutputStream(fos,5);
			
			//파일 123.txt에 1부터 9까지 출력
			for(int i='1'; i <= '9'; i++) {
				bos.write(i);
			}//for
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
