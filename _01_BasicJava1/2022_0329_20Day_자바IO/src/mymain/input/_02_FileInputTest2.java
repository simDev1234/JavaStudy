package mymain.input;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class _02_FileInputTest2 {
	public static void main(String[] args) throws Exception {
		//ȭ�� ��ǲ���� ��ĳ�����ؼ� �޴´�.
		InputStream is = new FileInputStream("src/mymain/input/_02_FileInputTest2.java");
		
		//���ڽ�Ʈ�� ����
		InputStreamReader isr = new InputStreamReader(is);
		
		int ch;
		
		while(true) {
			ch = isr.read(); //char������ �д´�.
			if(ch==-1) break;
			System.out.printf("%c",ch);
		}
		
		is.close();
	}
}
