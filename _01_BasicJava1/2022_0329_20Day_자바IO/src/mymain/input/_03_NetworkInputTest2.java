package mymain.input;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class _03_NetworkInputTest2 {
	
	//웹 html은 UTF-8로 문자를 인코딩 
	//---> 이걸 이클립스에서 실행(현재 이클립스 MS949)
	//※해결방법 : 문자스트림필터 생성할 때, CharsetName을 같이 넣는다. (Charset = 인코팅종류)

	public static void main(String[] args) throws Exception {
		String str_url = "https://www.naver.com/";
		
		URL url = new URL(str_url);
		
		InputStream is = url.openStream(); //현재 연결된 서버로부터 데이터를 읽어올 수 있는 스트림
		
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		
		int ch;
		//int count = 0;
		while(true) {
			//count++;
			//if(count>1000) break;
			ch = isr.read(); //한글자씩
			if(ch==-1) break;
			System.out.printf("%c",ch);
		}
	}

}
