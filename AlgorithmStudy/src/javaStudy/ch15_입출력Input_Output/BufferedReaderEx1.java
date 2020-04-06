package javaStudy.ch15_입출력Input_Output;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderEx1 {
	/*
	 * 문자기반의 보조스트림
	 * BufferedReader/BufferedWriter -> 버퍼를 이용해서 입출력의 효율을 높임
	 * BufferedReader -> readLine() -> 데이터를 라인단위로 읽음
	 * BufferedWriter - > newLine() -> 줄바꿈
	 * */
	
	//BufferedReader의 readLine()을 이용해서 파일을 라인단위로 읽은 다음 indexOf()를
	//이용해서 ';'를 포함하고 있는지 확인하여 출력하는 예제
	public static void main(String[] args) {
		try {
			
			FileReader fr = new FileReader("BufferedReaderEx1.java");
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			for(int i = 1; (line = br.readLine()) != null; i++) {
				//";"를 포함한 라인을 출력
				if(line.indexOf(";") != -1) 
					System.out.println(i + ":"+line);
			}//for
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
