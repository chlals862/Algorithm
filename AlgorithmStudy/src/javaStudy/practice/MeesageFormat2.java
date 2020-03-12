package javaStudy.practice;

import java.text.MessageFormat;

public class MeesageFormat2 {

	public static void main(String[] args) {
		String pattern = "VALUES (\"{0}\",''{1}'',{2},''{3}'')";
		Object[][] argument = {{"이자바","30세","경기도","학생"},{"김프로","35세","서울","직장인"}};
		
		String[] result = new String[2];
		for(int i=0;i<argument.length;i++) {
			result[i] = MessageFormat.format(pattern, argument[i]);
			System.out.println(result[i]);
		}
		
		MessageFormat mf = new MessageFormat(pattern);
		Object[][] lastResult;
		
		try {
			for(int i=0;i<result.length;i++) {
				Object[] obj = mf.parse(result[i]);
				for(int j=0;j<obj.length;j++) {
				lastResult = new String[result.length][obj.length];
				lastResult[i][j] = (String)obj[j]; //다시 2차원 배열로 전환
			System.out.print("obj["+i+"]["+j+"] : " + lastResult[i][j]);
				
			if(j != obj.length-1)
				System.out.print(", ");
			}
				System.out.println();
		}
	} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
}
