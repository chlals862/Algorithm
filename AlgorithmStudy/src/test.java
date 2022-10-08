import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[5][15]; //5행 15열
		
		for(int row=0;row<arr.length;row++) { //5
			String str = sc.nextLine(); //단어 길이 입력
			for(int col=0;col<str.length();col++) { //단어 길이만큼
				arr[row][col] = str.charAt(col);
			}
		}
		
		/* 출력
		for(int row=0;row<5;row++) {
			for(int col=0;col<15;col++) {
				System.out.print(arr[row][col] + " ");
			}
			System.out.println();
		}
		*/
		for(int row=0;row<15;row++) {
			for(int col=0;col<5;col++) {
				if(arr[col][row] == '\0') { //char에서 빈 문자 생성 \0 -> 유니코드
					continue; //공백이면 넘어가기
				}
				System.out.print(arr[col][row]+"");
			}
			
		}
	}
}
