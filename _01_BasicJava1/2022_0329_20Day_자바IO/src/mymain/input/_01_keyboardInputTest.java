package mymain.input;

import java.io.IOException;
import java.io.InputStream;

public class _01_keyboardInputTest {

	public static void main(String[] args) throws IOException {
		int ch;
		
		InputStream is = System.in;
		
		System.out.println("종료하려면 [Ctrl+Z]");
		
		while(true) {
			//키보드 버퍼로부터 1byte읽어오기(한글은 2byte라 깨짐)
			ch = is.read();
			
			if(ch==-1) break;
			
			System.out.printf("%c",ch);
		}//end while
		
		System.out.println("---End---");
	}

}
