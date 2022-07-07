package mymain.input;

import java.io.InputStream;
import java.net.URL;

public class _03_NetworkInputTest {

	public static void main(String[] args) throws Exception {
		String str_url = "https://www.naver.com/";
		
		URL url = new URL(str_url);
		
		InputStream is = url.openStream(); //현재 연결된 서버로부터 데이터를 읽어올 수 있는 스트림
		
		int ch;
		//int count = 0;
		while(true) {
			//count++;
			//if(count>1000) break;
			ch = is.read();
			if(ch==-1) break;
			System.out.printf("%c",ch);
		}
	}

}
