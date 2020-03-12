package javaStudy.practice;

import java.text.MessageFormat;

public class MessageFormat1 {
	
	public static void main(String[] args) {
		
		String pattern = "첫번째 : {0} \n두번쨰 : {1} \n세번쨰 : {2} \n네번째 : {3}";
		Object[] arguments = {"가나다","ABC","123","!@#"};
	
		String result = MessageFormat.format(pattern, arguments);
		System.out.println(result);
	}
}
