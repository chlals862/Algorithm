package javaStudy.ch15_입출력Input_Output;
	/*
	 * 다음 예제에 사용된 클래스의 소스
	 * */
public class UserInfo implements java.io.Serializable{

	/*
	 * 직렬화(serialization) -> 객체를 데이터 스트림으로 만드는것 
	 * -> 객체에 저장된 데이터를 스트림에 쓰기위해 연속적인 데이터로 변환하는것
	 * 
	 * 역직렬화(deserialization) -> 반대로 스트림으로부터 데이터를 읽어서 객체를 만드는것
	 * */
	
	String name;
	String password;
	int age;

	public UserInfo() {
		this("Unknown", "1111", 0);
	}
	
	public UserInfo(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	public String toString() {
		return "(" + name + "," + password + "," + age + ")";
	}
}
