package mymain.input;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class _03_NetworkInputTest3 {
	
	//BufferedReader로 한 번 더 씌워줌
	//버퍼에 미리 데이터를 받아두고, 읽을 때 한 줄씩 읽어옴
	//성능향상(읽는 속도가 더 빠름)

	public static void main(String[] args) throws Exception {
		String str_url = "https://www.naver.com/";
		
		URL url = new URL(str_url);
		
		InputStream is = url.openStream(); //현재 연결된 서버로부터 데이터를 읽어올 수 있는 스트림
		
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		
		BufferedReader bsr = new BufferedReader(isr);
		
		//int ch;
		//int count = 0;
		while(true) {
			
			String readStr = bsr.readLine();//1줄씩 수신(Enter는 버림)
			if(readStr==null) break;
			System.out.println(readStr); //Enter버리니까 println으로 출력해야함
			
			Thread.sleep(1000);
			
			//count++;
			//if(count>1000) break;
			//ch = isr.read(); //한글자씩
			//if(ch==-1) break;
			//System.out.printf("%c",ch);
		}
	}

}
