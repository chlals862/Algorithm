package javaStudy.ch09_java.lang패키지;

import java.util.Scanner;

public class ScannerEx1 {
	/* boolean -> nextBoolean()
	 * byte	   -> nextByte()
	 * short   -> nextShort()
	 * int     -> nextInt()
	 * long    -> nextLong()
	 * double  -> nextDouble()
	 * float   -> nextFloat()
	 * String  -> nextLine()
	 * */
	public static void main(String[] args) {
		//화면으로부터 라인단위로 입력받아서 입력받은 내용을 공백을 구분자로 나눠서 출력하는 예제
		Scanner sc = new Scanner(System.in);
		String[] argArr = null;
		
		while(true) {
			String prompt = ">>";
			System.out.print(prompt);
			
			//화면으로부터 라인단위로 입력 받음
			String input = sc.nextLine();
			
			input = input.trim(); //앞뒤 공백제거
			
			//입력받은 라인의 단어는 공백이 여러 개 일 수 있으므로 정규식을 " +"로 함
			//이 정규식의 의미는 하나 이상의 공백을 의미
			argArr = input.split(" +"); //입력받은 내용을 공백을 구분자로 자름
			
			
			
			String command = argArr[0].trim();
			
			if("".equals(command)) continue;
			
			//명령어를 소문자로 바꿈
			command = command.toLowerCase();
			
			//q또는 Q를 입력하면 실행종료
			if(command.equals("q")) {
				System.exit(0);
			} else {
				for(int i=0;i<argArr.length;i++) 
					System.out.println(argArr[i]);
			}
		}//while of end
	}
}
