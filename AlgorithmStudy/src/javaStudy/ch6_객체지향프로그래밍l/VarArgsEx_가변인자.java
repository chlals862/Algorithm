package javaStudy.ch6_객체지향프로그래밍l;

public class VarArgsEx_가변인자 {
/*
 * 여러 문자열을 하나도 결합하여 반환하는 메서드 -> concatenate() 
 * */
	public static void main(String[] args) {
		
		String[] strArr = { "100", "200", "300" };
		
		System.out.println(concatenate("", "100","200","300"));
		System.out.println(concatenate("-", strArr));
		System.out.println(concatenate(",", new String[] {"1","2","3"}));
		System.out.println("["+concatenate(",", new String[0])+"]");
		System.out.println("["+concatenate(",")+"]");
	
		//String[] strArr = { "100", "200", "300" };
		//System.out.println(concatenate("-", strArr)); 
		//이 두문장 단순화 가능
		//System.out.println(concatenate("-",new String[]{"100","200","300"}));   O
 
//하지만        System.out.println(concatenate("-",{"100","200","300"})); X        
	}
	
	static String concatenate(String delim, String... args) {
		String result = "";
		
		for(String str : args) {
			result += str + delim;
		}//for of end
		
		return result;
	}
}
