package javaStudy.ch14_람다식_스트림;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {

	public static void main(String[] args) {
		Student2[] stuArr = {
				new Student2("홍길동", 3, 300),
				new Student2("케이틀린", 1, 200),
				new Student2("김철수", 2, 100),
				new Student2("가나다", 2, 150),
				new Student2("샘", 1, 200),
				new Student2("벤틀리", 3, 290),
				new Student2("윌리엄", 3, 350)
		};
		
		Stream<Student2> stuStream = Stream.of(stuArr);
		
		stuStream.sorted(Comparator.comparing(Student2::getBan) //반별 정렬
				.thenComparing(Comparator.naturalOrder()))		//기본 정렬
				.forEach(System.out::println);
		
		stuStream = Stream.of(stuArr); //스트림 재생성
		IntStream stuScoreStream = stuStream.mapToInt(Student2::getTotalScore);
		//IntSummaryStatistics -> sum()과 average()를 모두 호출 해야할때 스트림을 또 생성해야하므로 불편한데 이 메서드를 사용하면 
		//스트림을 다시 생성할 필요가 없음
		IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
		System.out.println("count = " + stat.getCount());
		System.out.println("sum = " + stat.getSum());
		System.out.printf("average = %,2f%n", stat.getAverage());
		System.out.println("min = " + stat.getMin());
		System.out.println("max = " + stat.getMax());
	
	}
}

class Student2 implements Comparable<Student2> {
	String name;
	int ban;
	int totalScore;
	
	Student2(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	
	public String toString() {
		return String.format("[%s, %d, %d]",name, ban, totalScore).toString();
	}
	
	String getName() { return name; }
	int getBan() { return ban; }
	int getTotalScore() { return totalScore; }

	public int compareTo(Student2 s) {
		return s.totalScore - this.totalScore;
	}

}