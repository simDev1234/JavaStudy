package mymain.output;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class _02_FileOutputTest2 {
	
	public static void main(String[] args) throws Exception{
		
		OutputStream os = new FileOutputStream("a.txt");
		
		os.write('A'); //������ write�� �ص� ��
		
		String msg = "�ȳ�";
		//String -> byte[]�� ����
		byte[] msg_bytes = msg.getBytes();
		os.write(msg_bytes);
		
		int n = 123;
		String s = String.valueOf(n);
		os.write(s.getBytes());
		
		boolean bOk = true;
		os.write(String.valueOf(bOk).getBytes());
		
		//PrintStream����
		PrintStream out = new PrintStream(os);
		out.println();
		out.println("�ϴ� ���� ����� ���� ��������. �� �� �ִ�.");
		
		int age = 20;
		String name = "ȫ�浿";
		
		out.printf("�̸� : %s%n", name);
		out.printf("���� : %d(��)%n", age);
		
		os.close();
		
	}
	
}
