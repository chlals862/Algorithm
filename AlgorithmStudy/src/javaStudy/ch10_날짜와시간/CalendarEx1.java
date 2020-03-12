package javaStudy.ch10_날짜와시간;

import java.util.Calendar;

public class CalendarEx1 {
	/* Calendar는 추상클래스이기 때문에 직접 객체를 생성할 수 없음
	 * 메서드를 통해서 완전히 구현된 클래스의 인스턴스를 얻어야함
	 * 
	 * ex) Calendar cal = new Calendar() -> 에러 ! 추상클래스는 인스턴스를 생성할 수 없음
	 *     Calendar cal = Calendar.getInstance(); -> OK
	 * 
	 * */
	public static void main(String[] args) {
		//기본적으로 현재날짜와 시간으로 설정된다.
		Calendar today = Calendar.getInstance();
	
		System.out.println("이 해의 년도 : " + today.get(Calendar.YEAR));
		System.out.println("월(0~11, 0:1월): " + today.get(Calendar.MONTH));
		System.out.println("이 해의 몇 째 주: " + today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("이 달의 몇 째 주: " + today.get(Calendar.WEEK_OF_MONTH));
		
		//DATE와 DAY_OF_MONTH는 같음
		System.out.println("이 달의 몇 일: " + today.get(Calendar.DATE));
		System.out.println("이 달의 몇 일: " + today.get(Calendar.DAY_OF_MONTH));
		System.out.println("이 해의 몇 일 " + today.get(Calendar.DAY_OF_YEAR));
		System.out.println("요일(1~7, 1:일요일): " + today.get(Calendar.DAY_OF_WEEK)); //1:일요일,2:월요일 ...
		System.out.println("이 달의 몇 쨰 요일: " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		
		System.out.println("오전_오후(0:오전, 1:오후): " + today.get(Calendar.AM_PM));
		System.out.println("시간(0~11): " + today.get(Calendar.HOUR));
		System.out.println("시간(0~23): " + today.get(Calendar.HOUR_OF_DAY));
		System.out.println("분(0~59): " + today.get(Calendar.MINUTE));
		System.out.println("초(0~59): " + today.get(Calendar.SECOND));
		System.out.println("1000분의 1초(0~999): " + today.get(Calendar.MILLISECOND));
		
		//1000분의 1초를 시간으로 표시하기 위해 3600000으로 나눔
		System.out.println("TimeZone(-12~+12): " + (today.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
		
		System.out.println("이 달의 마지막 날 :" + today.getActualMaximum(Calendar.DATE)); //이 달의 마지막 일을 찾음
	}
}
