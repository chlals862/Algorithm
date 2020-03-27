package javaStudy.ch14_람다식_스트림;

import java.util.Comparator;
import java.util.stream.Stream;

public class SteamEx1_스트림정렬 {

	public static void main(String[] args) {
		Stream<Student> studentStream = Stream.of(
				new Student("홍길동", 3, 300),
				new Student("케이틀린", 1, 200),
				new Student("김철수", 2, 100),
				new Student("가나다", 2, 150),
				new Student("샘", 1, 200),
				new Student("벤틀리", 3, 290),
				new Student("윌리엄", 3, 160)
				);
		
		studentStream.sorted(Comparator.comparing(Student::getBan) //반별 정렬
				.thenComparing(Comparator.naturalOrder())) 		   //기본 정렬
				.forEach(System.out::println);
	}
}

class Student implements Comparable<Student> {
	String name;
	int ban;
	int totalScore;
	
	Student(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore = totalScore;
	}
	public String toString() {
		return String.format("[%s, %d, %d]", name, ban, totalScore);
	}
	
	String getName() {
		return name;
	}
	int getBan() {
		return ban;
	}
	int totalScore() {
		return totalScore;
	}

	//총점 내림차순을 기본 정렬로 함
	public int compareTo(Student s) {
		return s.totalScore - this.totalScore;
	}
}
	/*
	 * 학생의 성적 정보를 요소로 하는 Stream<Student>을 반별로 정렬한 다음,
	 * 총점별 내림차순으로 정렬
	 * ---------------------------------------------------------------------------
	 * 정렬하는 코드를 짧게 하기위해 Comparable을 구현해서 총점별 내림차순 정렬이 Student의 기본 정렬이 되도록 함
	 * */