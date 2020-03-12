package javaStudy.ch09_java.lang패키지;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularEx2_정규식 {
	/*
	 * c[a-z]* -> c로 시작하는 영단어
	 * c[a-z] -> c로 시작하는 두 자리 영단어
	 * c[a-zA-Z] -> c로 시작하는 두 자리 영단어 (a~z 또는 A~Z, 즉 대소문자 구분 안함)
	 * c[a-zA-Z0-9]c\w -> c로 시작하고 숫자와 영어로 조합된 두 글자
	 * .* -> 모든 문자열
	 * c. -> c로 시작하는 두 자리 문자열
	 * c.* -> c로 시작하는 모든 문자열(기호 포함)
	 * c\. -> c.와 일치하는 문자열 '.'은 패턴작성에 사용되는 문자이므로 escape문자인 '\'를 사용해야함  ##결과 : c.,
	 * c\d    c[0-9] -> c와 숫자로 구성된 두 자리 문자열 
	 * c.*t -> c로 시작하고 t로 끝나는 모든 문자열
	 * 
	 * [b|c].*
	 * [bc].*  -> b 또는 c로 시작하는 문자열
	 * [b-c].*
	 * 
	 * [^b|c].*
	 * [^bc].* -> b 또는 c로 시작하지 않는 문자열
	 * [^b-c].*
	 * 
	 * .*a.* -> a를 포함하는 모든 문자열   ## * -> 0또는 그 이상의 문자
	 * .*a.+ -> a를 포함하는 모든 문자열   ## + -> 1 또는 그 이상의 문자. '+'는 '*'와 달리 반드시 하나 이상의 문자가 있어야 하므로 a로 끝나는 단어는 포함되지 않음
	 * [b|c].{2} -> b 또는 c로 시작하는 세 자리 문자열.(b또는 c다음에 두 자리이므로 모두 세자리)
	 * 
	 * */
	public static void main(String[] args) {
		String[] data = {"bat","baby","bonus","cA","ca","co","c.","c0","car","combat","count","date","disc"};
		
		String[] pattern = {".*","c[a-z]*","c[a-z]","c[a-zA-Z]",
				"c[a-zA-Z0-9]","c.","c.*","c\\.","c\\w","c\\d",
				"c.*t","[b|c].*",".*a.*",".*a.+","[b|c].{2}"};
		
		for(int i=0;i<pattern.length;i++) {
			Pattern p = Pattern.compile(pattern[i]);
			System.out.print("Pattern : " + pattern[i] + " 결과 : ");
			
			for(int j=0; j<data.length;j++) {
				Matcher m = p.matcher(data[j]);
				if(m.matches())
					System.out.print(data[j] + ",");
			}
			System.out.println();
		}
	}
}
