package mymain.output;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class _02_FileOutputTest {
	
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
		
		os.close();
		
	}
	
}
