package javaStudy.ch4_조건문과반복문;

public class FlowEx19_중첩반복문2 {

	public static void main(String[] args) {
		for(int i = 1; i <= 3; i++)
			for(int j = 1; j <= 3; j++)
				for(int k = 1; k <= 3; k++)
					System.out.println(""+i+j+k); //""를 넣은 이유는 p35참고 , 공백이 들어가면 나머지 i,j,k도 문자열로 인식됨
				
	}
}
