package javaStudy.ch12_제너릭스_열거형_어노테이션;

//만약 열거형 상수의 값이 불연속적인 경우엔 열거형 상수의 이름 옆에 원하는 값을 괄호()와 함꼐 적어주면 됨 -> 마지막에 ';'달아야 함
enum Direction { EAST, SOUTH, WEST, NORTH } 

public class EnumEx1_열거형 {

	public static void main(String[] args) {
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println("d1 = " + d1);
		System.out.println("d2 = " + d2);
		System.out.println("d3 = " + d3);
		System.out.println("d1==d2 ? " + (d1==d2));
		System.out.println("d1==d3 ? " + (d1==d3));
		System.out.println("d1.equals(d3) ? " + d1.equals(d3));
		//열거형에서는 '<'나'>'같은 연산자는 불가
		System.out.println("d1.compareTo(d3) ? " + d1.compareTo(d3)); //CompareTo -> 같으면 0  왼쪽이 크면 양수  오른쪽이 크면 음수
		System.out.println("d1.compareTo(d2) ? " + d1.compareTo(d2));
		
		
		switch(d1) {
		
		case EAST : //Direction.EAST라고 쓸 수 없음
			System.out.println("The direction is EAST."); break;
		case SOUTH :
			System.out.println("The direction is SOUTH."); break;
		case NORTH :
			System.out.println("The direction is NORTH."); break;
		case WEST :
			System.out.println("The direction is WEST."); break;
		}//end of switch
		
		Direction[] dArr = Direction.values();
		
		for(Direction d : dArr) //for(Direction d : Direction.values())
			
			//ordinal -> 해당 값이 enum에 정의된 순서를 리턴
			System.out.printf("%s=%d%n", d.name(),d.ordinal());
		
		
	}
}
