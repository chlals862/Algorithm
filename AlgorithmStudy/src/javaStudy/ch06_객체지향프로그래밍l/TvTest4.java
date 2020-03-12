package javaStudy.ch06_객체지향프로그래밍l;

class Tv {
	String color;
	boolean power;
	int channel;
	
	void power() {
		power = !power;
	}
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
}

public class TvTest4 {
	
	public static void main(String[] args) {
		Tv[] tvArr = new Tv[3];
		
		//Tv객체를 생성하여 Tv객체 배열의 각 요소에 저장
		for(int i=0; i<tvArr.length; i++) {
			tvArr[i] = new Tv();
			tvArr[i].channel = i+10;
		}//for of end
		
		for(int i=0; i<tvArr.length;i++) {
			tvArr[i].channelUp();
			System.out.printf("tvArr[%d].channel=%d%n",i,tvArr[i].channel);
		}
	}//main of end
}

