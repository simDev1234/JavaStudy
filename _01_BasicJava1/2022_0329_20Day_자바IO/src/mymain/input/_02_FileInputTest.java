package mymain.input;

import java.io.FileInputStream;
import java.io.InputStream;

public class _02_FileInputTest {
	public static void main(String[] args) throws Exception {
		//ȭ�� ��ǲ���� ��ĳ�����ؼ� �޴´�.
		InputStream is = new FileInputStream("src/mymain/input/_02_FileInputTest.java");
		
		int ch;
		
		while(true) {
			ch = is.read();
			if(ch==-1) break;
			System.out.printf("%c",ch);
		}
		
		is.close();
	}
}
