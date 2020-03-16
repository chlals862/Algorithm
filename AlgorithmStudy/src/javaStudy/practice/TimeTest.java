package javaStudy.practice;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class TimeTest {

	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2014, 1, 1);
		LocalDate date2 = LocalDate.of(2015, 12, 31);
		
		//Period -> 날짜의 차이
		//Duration -> 시간의 차이
		//between -> 두 날짜 date1과 date2의 차이를 나타내는 Period는 between()으로 얻을 수 있음
		Period pe = Period.between(date1, date2);
		System.out.println(pe); //결과값 : P1Y11M30D -> 1년 11개월 30일 차이
		
		LocalTime time1 = LocalTime.of(00,00,00);
		LocalTime time2 = LocalTime.of(12,34,56);
		Duration du = Duration.between(time1,time2);
		//결과값 : PT12H34M56S -> 12시간 34분 56초차이
		System.out.println(du);
		
		//Period,Duration에서 특정 필드의 값을 얻을 때는 get()을 사용
		long year = pe.get(ChronoUnit.YEARS); //int getYears();
		long month = pe.get(ChronoUnit.MONTHS);
		long day = pe.get(ChronoUnit.DAYS);
		
		long sec = du.get(ChronoUnit.SECONDS);
		int nano = (int) du.get(ChronoUnit.NANOS);
		
		System.out.println("P1Y11M30D : " + year +":"+ month +":"+ day +":"+ sec +":"+ nano);
		
	}
}
