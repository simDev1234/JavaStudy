package mymain;

public class MyMain_Ex_String1 {

	public static void main(String[] args) {
		//String ��ü ���� ���
		//1. �Ͻ��� ��� : ��� Pool(Ŭ���������� ����)�� �޸𸮰��� �Ҵ�
		String name = "";
		//2. ����� ��� : Heap������ �ν��Ͻ��� �����Ǿ� ���ڿ� ����
		String s = new String("Hello");
		
		//���ڿ� ��
		
		//1. �Ͻ��� ���
		String s1 = "Twinkle"; //java�� ���־��� ���ڿ��� ����
		String s2 = "Twinkle"; //constant pool�� �� ���ڿ��� �ְ�, s1�� s2�� �����ϰ� ��
		                       //(�׻� �׷����� ����)
		if(s1 == s2)
			System.out.println("---SAME---");
		else
			System.out.println("---Diff---");
		
		
		//2. ����� ���
		String s3 = new String("Little Star");
		String s4 = new String("Liitle Star");
		
		if(s3 == s4)
			System.out.println("---SAME---");
		else
			System.out.println("---Diff---");
	}

}																																																														
