package mymain.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class _01_keyboardInputTest2 {

	public static void main(String[] args) throws IOException {
		int ch;
		
		//����Ʈ��Ʈ��
		InputStream is = System.in;
		
		//���ڽ�Ʈ������ Filter
		InputStreamReader isr = new InputStreamReader(is);
		
		System.out.println("�����Ϸ��� [Ctrl+Z]");
		
		while(true) {
			//Ű���� ���۷κ��� 1byte�о�� ���� -> char��ȯ�ؼ� ���޵� isr�κ��� �б�
			ch = isr.read();
			
			if(ch==-1) break;
			
			System.out.printf("%c",ch);
		}//end while
		
		System.out.println("---End---");
	}

}
