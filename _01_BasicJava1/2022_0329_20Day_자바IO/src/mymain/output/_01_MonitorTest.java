package mymain.output;

import java.io.OutputStream;

public class _01_MonitorTest {

	public static void main(String[] args) throws Exception {
		
		OutputStream os = System.out;
		
		os.write(65); //������� to ��¹���
		
		String msg = "�ȳ�";
		//String -> byte[]�� ����
		byte[] msg_bytes = msg.getBytes();
		os.write(msg_bytes);
		
		int n = 123;
		String s = String.valueOf(n);
		os.write(s.getBytes());
		
		boolean bOk = true;
		os.write(String.valueOf(bOk).getBytes());
		
		os.flush(); //flush : ��¹��۸� ���鼭 --> �ַܼ� ������
		
	}

}
