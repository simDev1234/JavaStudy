package mymain;

public class MyMain_Ex_String2_�Һ���Ư¡ {

	public static void main(String[] args) {
		
		//String ��ü�� ��� ����� �Ǵ� �޼ҵ� ��� ��, ���ο� ��ü�� ����
		
		String str = "abc";
		//���� ��ü�� �̿��Ͽ� ���ο� �빮�� ��ü�� ����
		String str1 = str.toUpperCase();
		System.out.println(str);
		System.out.println(str1);
		
		String msg = "�� ������ ������";
		String msg1 = msg.replaceAll("������", "**");
		//msg = msg.replaceAll("������", "**");
		System.out.printf("[����] : %s\n",msg);
		System.out.printf("[����] : %s\n",msg1);
		
		String s = "���";   //"���" - 0x100 **������
		s = s + " �����ٰ�"; //"��� �����ٰ�" - 0x200 **������
		s = s + " �մϴ�.";  //"��� �����ٰ� �մϴ�." - 0x300
		System.out.println(s);
		
		/*
		String str2 = str;
		str2.toUpperCase(); <<--- �̰� �ϰ� �Ǹ� ��ü �� ������
		*/
		
	}

}
