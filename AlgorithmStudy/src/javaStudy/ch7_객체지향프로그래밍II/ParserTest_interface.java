package javaStudy.ch7_객체지향프로그래밍II;
/*mjmimjmimimijmimimimimimimimimimimimimimijmijmijmijmijk,,kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk*/
interface Parseable {
	//구문 분석작업을 수행
	public abstract void parse(String fileName);
}

class ParserManager {
	//리턴타입이 Parseable인터페이스이다.
	public static Parseable getParser(String type) {
		if(type.equals("XML")) {
			return new XMLParser();
		}else {
			Parseable p = new HTMLParser();
			return p;
			//return new HTMLParser();
		}
	}
}
class XMLParser implements Parseable {
	public void parse(String fileName) {
		/*구문 분석작업을 수행하는 코드 작성*/
		System.out.println(fileName + "- XML parsing completed.");
	}
}
class HTMLParser implements Parseable {
	public void parse(String fileName) {
		/*구문 분석작업을 수행하는 코드 작성*/
		System.out.println(fileName + "- HTML parsing completed.");
	}
}

public class ParserTest_interface {

	public static void main(String[] args) {
		Parseable parser = ParserManager.getParser("XML");
		parser.parse("Document.xml");
		parser = ParserManager.getParser("HTML");
		parser.parse("Document2.html");
	}
}
