package member.controller;

public class Ex01 {

	public static void main(String[] args) {
		// 공백도 문자다!
		
		String str1 = "Hello World";
		String str2 = "  Hello World";
		String str3 = "Hello World  ";
		String str4 = "  Hello World  ";
		
		System.out.println("str1의 길이 => " + str1.length());
		System.out.println("str2의 길이 => " + str2.length());
		System.out.println("str3의 길이 => " + str3.length());
		System.out.println("str4의 길이 => " + str4.length());
		
		// trim() 메서드 : 메서드는 문자열 양 끝의 공백을 제거합니다. 공백이란 모든 공백문자(space, tab, NBSP 등)와 모든 개행문자(LF, CR 등)를 의미합니다.
		str2.trim();
		System.out.println("str2의 길이 => " + str2.length());
		// 다시 저장시켜줘야한다.
		
		str2 = str2.trim();
		System.out.println("str2의 길이 => " + str2.length());
		
		String id = "        ";
		id = id.trim();
		
		if(id.length() == 0) {
			System.out.println("아이디가 공백으로만 이루어져 있습니다.");
		}
		
	}

}
