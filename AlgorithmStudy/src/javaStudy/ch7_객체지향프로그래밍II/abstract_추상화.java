package javaStudy.ch7_객체지향프로그래밍II;

public class abstract_추상화 {
	/*
	 * 추상클래스 -> 설계도에 비유시 미완성 설계도
	 * ->멤버의 개수에 관계된 것이 아닌, 단지 미완성 메서드(추상메서드)를 포함하고 있다는 의미
	 * 추상클래스는 키워드 'abstarct'를 붙이기만 하면 됌
	 * 추상클래스는 추상메서드를 포함하고 있다는 것을 제외하고는 일반클래스와 전혀 다르지 않음
	 * ===========================================================
	 * 메서드는 선언부와 구현부(몸통)로 구성되어 있음
	 * 추상메서드 -> 선언부만 작성하고 구현부는 작성하지 않은 채로 남겨 둔 것
	 * 즉, 설계만 해 놓고 실제 수행될 내용은 작성하지 않았기 때문에 미완성 메서드임
	 * 
	 * 메서드를 이렇게 미완성 상태로 남겨 놓는 이유는 
	 * 메서드의 내용이 상속받는 클래스에 따라 달라질 수 있기 때문에 
	 * 조상 클래스에서는 선언부만을 작성하고, 주석을 덧붙여 어떤 기능을 수행할 목적으로 작성되었는지 알려 주고,
	 * 실제 내용은 상속받는 클래스에서 구현하도록 비워 두는 것
	 * 추상메서드 역시 키워드 'abstarct'를 앞에 붙여 주고, 추상메서드는 구현부가 없으므로 괄호{}대신 문장의 끝을 알리는 ;을 적어줌
	 * abstract 리턴타입 메서드이름();
	 * 추상클래스로부터 상속받는 자손클래스는 오버라이딩을 통해 조상인 추상클래스의 추상메서드를 모두 구현해줘야 함
	 * */
		abstract class Player { //추상 클래스
			abstract void play(int pos); //추상 메서드
			abstract void stop();		 //추상 메서드
		}
		class AudioPlayer extends Player {
			void play(int pos) {/*내용 생략*/} //추상메서드를 구현
			void stop() {/*내용 생략*/}	 		//추상메서드를 구현
		}
		abstract class AbstractPlayer extends Player {
			void play(int pos) {/*내용 생략*/} //추상메서드를 구현
		}

		/*
		 * 추상 -> 공통된 성질을 뽑아 이를 일반적인 개념으로 파악
		 * 추상화 -> 기존의 클래스의 공통부분을 뽑아내서 조상 클래스를 만드는 것
		 * 추상화를 구체화와 반대되는 의미로 이해
		 * 구체화 -> 상속을 통해 클래스를 구현, 확장하는 작업
		 * */
		
		//==================================================================
		/*
		 * 기존의 클래스로부터 공통된 부분을 뽑아내서 추상클래스를 만드는 예제
		 * 
		class Marine {
			int x, y; //헌재 위치
			void move(int x, int y){} //지정된 위치로 이동
			void stop(){}			 //현재 위치에 정지
			void stimPack()	{}	   //스팀팩 사용
		}
		class Tank {
			int x, y;
			void move(int x, int y){}
			void stop(){}
			void changeMode(){}
		}
		class Dropship {
			int x, y;
			void move(int x, int y){}
			void stop(){}
			void load(){}
			void unload() {}
		}
		*///▼▼▼▼▼▼▼▼▼▼▼▼ 여기서 공통되는 부분을 뽑아냄
		/*
		 * 공통부분을 뽑아내서 Unit클래스를 정의하고 이로부터 상속받도록 함
		 * 이들 클래스에 대해서 stop메서드는 선언부와 구현부 모두 공통적이지만
		 * Marine,Tank는 지상유닛. DropShip은 공중유닛이기 때문에 이동하는 방법이 서로 달라서 move메서드으 실제 구현 내용이 다를것
		 * 그래도 move메서드의 선언부는 같기 때문에 추상메서드로 정의할 수 있음
		abstarct class Unit { ★★★★★★★★★★★★★★
			int x, y;
			abstract void move(int x, int y);
			void stop() {}
		}
		class Marine extends Unit {
			void move(int x, int y) {}
			void stimPack() {}
		}
		class Tank extends Unit {
			void move(int x, int y) {}
			void changeMode() {}
		}
		class DropShip extends Unit {
			void move(int x, int y) {}
			void load() {}
			void unload() {}
		}
		*/

}
