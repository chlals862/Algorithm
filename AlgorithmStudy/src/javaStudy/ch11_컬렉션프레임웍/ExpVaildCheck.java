package javaStudy.ch11_컬렉션프레임웍;

import java.util.Stack;

public class ExpVaildCheck {
	/*
	 * 입력한 수식의 괄호가 올바른지를 체크하는 예제
	 * '('를 만나면 스택에 넣고 
	 * ')'를 만나면 스택에서 '('를 꺼냄
	 * 
	 * ')'를 만나서 '('를 꺼내려 할 떄 스택이 비어있거나 수식을 검사하고 난 후에도 스택이 비어있지 않으면 괄호가 잘못됨
	 * ')'를 만나서 '('를 꺼내려 할 때 스택이 비어있으면 Exception이 발생하므로 try-catch문 사용
	 * */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage :  + java ExpVaildCheck \"EXPRESSION\"");
			System.out.println("Example : java ExpVaildCheck \" ((2+3)*1) + 3\"");
			//System.exit(0);
		}

		Stack st = new Stack();
		String expression = args[0];

		System.out.println("expression : " + expression);

		try {
			for (int i = 0; i < expression.length(); i++) {

				char ch = expression.charAt(i);

				if (ch == '(') {
					st.push(ch + "");
				} else if (ch == ')') {
					st.pop();
				}
			} // end of for

			if (st.isEmpty()) {
				System.out.println("괄호 일치");
			} else {
				System.out.println("괄호 불일치");
			}
			
		} catch (Exception e) {
			System.out.println("괄호 불일치");
			e.printStackTrace();
		}
	}
}
