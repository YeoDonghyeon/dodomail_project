package member.controller;

public class Ex01 {

	public static void main(String[] args) {
		// ���鵵 ���ڴ�!
		
		String str1 = "Hello World";
		String str2 = "  Hello World";
		String str3 = "Hello World  ";
		String str4 = "  Hello World  ";
		
		System.out.println("str1�� ���� => " + str1.length());
		System.out.println("str2�� ���� => " + str2.length());
		System.out.println("str3�� ���� => " + str3.length());
		System.out.println("str4�� ���� => " + str4.length());
		
		// trim() �޼��� : �޼���� ���ڿ� �� ���� ������ �����մϴ�. �����̶� ��� ���鹮��(space, tab, NBSP ��)�� ��� ���๮��(LF, CR ��)�� �ǹ��մϴ�.
		str2.trim();
		System.out.println("str2�� ���� => " + str2.length());
		// �ٽ� �����������Ѵ�.
		
		str2 = str2.trim();
		System.out.println("str2�� ���� => " + str2.length());
		
		String id = "        ";
		id = id.trim();
		
		if(id.length() == 0) {
			System.out.println("���̵� �������θ� �̷���� �ֽ��ϴ�.");
		}
		
	}

}
