package mymain.input;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class _01_keyboardInputTest2 {

	public static void main(String[] args) throws IOException {
		int ch;
		
		//바이트스트림
		InputStream is = System.in;
		
		//문자스트림으로 Filter
		InputStreamReader isr = new InputStreamReader(is);
		
		System.out.println("종료하려면 [Ctrl+Z]");
		
		while(true) {
			//키보드 버퍼로부터 1byte읽어온 내용 -> char변환해서 전달된 isr로부터 읽기
			ch = isr.read();
			
			if(ch==-1) break;
			
			System.out.printf("%c",ch);
		}//end while
		
		System.out.println("---End---");
	}

}
