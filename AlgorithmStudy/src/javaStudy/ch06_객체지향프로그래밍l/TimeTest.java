package javaStudy.ch06_객체지향프로그래밍l;

public class TimeTest {

		private int hour;
		private int minute;
		private float second;
		
		public int getHour() { 
			return hour;
		}
		public int getMinute() {
			return minute;
		}
		public float getSecond() {
			return second;
		}
		
		public void setHour(int h) {
			if(h<0 || h>23) return;
			hour=h;
		}
		public void setMinute(int m) {
			if(m<0 || m>59) return;
			minute=m;
		}
		public void setSecond(int s) {
			if(s<0 || s>59) return;
			second=s;
		}
	
}
