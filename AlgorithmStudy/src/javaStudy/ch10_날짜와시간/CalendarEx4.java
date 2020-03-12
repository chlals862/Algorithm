package javaStudy.ch10_날짜와시간;

import java.util.Calendar;

public class CalendarEx4 {

	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.set(2015, 7, 15); //2015년 8월 31일
		
		System.out.println(toString(date));
		System.out.println("= 1일 후 =");
		//add() -> 지정한 필드의 값을 원하는 만큼 증가 또는 감소 시킬 수 있음
		date.add(Calendar.DATE, 1);
		System.out.println(toString(date));
		
		System.out.println("= 6달 전 =");
		date.add(Calendar.MONTH, -6);
		System.out.println(toString(date));
		
		//roll도 add처럼 지정한 필드의 값을 원하는 만큼 증가 또는 감소를 시키지만 다른 필드에 영향을 미치지 않음
		// add메서드로 날짜필드의 값을 31만큼 증가시켰다면 다음 달로 넘어가므로 월 필드의 값도 1증가하지만
		//roll메서드 같은 경우는 월 필드의 값은 변하지 않고 일 필드의 값만 바뀜
		System.out.println("= 31일 후(roll) =");
		date.roll(Calendar.DATE, 31);
		System.out.println(toString(date));
		
		System.out.println("= 31일 후(add) =");
		date.add(Calendar.DATE, 31);
		System.out.println(toString(date));
	}
	
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 "+(date.get(Calendar.MONTH)+1) + "월 " + date.get(Calendar.DATE) + "일 ";
	}
}
