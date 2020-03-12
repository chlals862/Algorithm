package javaStudy.ch10_날짜와시간;

import java.text.MessageFormat;

public class MessageFormatEx1 {

	public static void main(String[] args) {
		
		String msg = "Name: {0} \nTel: {1} \nAge: {2} \nBirthday: {3}";
		
		Object[] arguments = {"이자바","02-123-1234","27","08-09"};
		
		String result = MessageFormat.format(msg, arguments);
		System.out.println(result);
	}
}
