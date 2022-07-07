package mymain.input;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class _02_FileInputTest2 {
	public static void main(String[] args) throws Exception {
		//화일 인풋으로 업캐스팅해서 받는다.
		InputStream is = new FileInputStream("src/mymain/input/_02_FileInputTest2.java");
		
		//문자스트림 필터
		InputStreamReader isr = new InputStreamReader(is);
		
		int ch;
		
		while(true) {
			ch = isr.read(); //char단위로 읽는다.
			if(ch==-1) break;
			System.out.printf("%c",ch);
		}
		
		is.close();
	}
}
