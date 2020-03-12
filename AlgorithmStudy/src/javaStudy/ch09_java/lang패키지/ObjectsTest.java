package javaStudy.ch09_java.lang패키지;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

public class ObjectsTest {

	public static void main(String[] args) {
		
		String[][] str2D = new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
		String[][] str2D_2 = new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
		System.out.print("str2D = {");
		for(String[] tmp : str2D)
			System.out.print(Arrays.toString(tmp));
		System.out.println("}");
		
		System.out.print("str2D_2 = {");
		for(String[] tmp : str2D_2)
			System.out.print(Arrays.toString(tmp));
		System.out.println("}");
		
		System.out.println("equals(str2D, str2D_2) = " + Objects.equals(str2D,str2D_2));
		System.out.println("deepEquals(strd2D, str2D_2) = " + Objects.deepEquals(str2D, str2D_2));
		System.out.println("isNull(null) = " + Objects.isNull(null));
		System.out.println("nonNull(null) = " + Objects.nonNull(null));
		
		//hashCode() 널일때 0반환
		System.out.println("hashCode(null) = " + Objects.hashCode(null));
		
		System.out.println("toString(null) = " + Objects.toString(null));
		System.out.println("toString(null, \"\")= " + Objects.toString(null, ""));
		
		Comparator c = String.CASE_INSENSITIVE_ORDER; //대소문자 구분 안하는 비교
		
		//compare() 두 비교대상이 같으면 0 , 크면 양수, 작으면 음수
		System.out.println("compare(\"aa\",\"bb\") = " + Objects.compare("aa","bb",c));
		System.out.println("compare(\"bb\",\"aa\") = " + Objects.compare("bb","aa",c));
		System.out.println("compare(\"ab\",\"AB\") = " + Objects.compare("ab","AB",c));
		
	
	
	}
}
