package mymain.input;

import java.io.InputStream;
import java.net.URL;

public class _03_NetworkInputTest {

	public static void main(String[] args) throws Exception {
		String str_url = "https://www.naver.com/";
		
		URL url = new URL(str_url);
		
		InputStream is = url.openStream(); //���� ����� �����κ��� �����͸� �о�� �� �ִ� ��Ʈ��
		
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
