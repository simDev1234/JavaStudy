package mymain.input;

import java.io.FileInputStream;
import java.io.InputStream;

public class _02_FileInputTest {
	public static void main(String[] args) throws Exception {
		//화일 인풋으로 업캐스팅해서 받는다.
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
