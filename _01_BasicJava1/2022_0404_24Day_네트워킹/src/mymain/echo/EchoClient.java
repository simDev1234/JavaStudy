package mymain.echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) throws Exception{

		//1. 접속 요청 : localhost <- 내부 IP
		Socket client = new Socket("localhost", 7000);
		System.out.println("--클라이언트 연결 성공--");
		
		//2. 전송/수신 스트림을 얻어온다.
		OutputStream os = client.getOutputStream(); //전송
		InputStream is = client.getInputStream();   //수신
		
		//3. 메시지 전송
		String msg = "안녕하세요";
		os.write(msg.getBytes());
		
		//4. 서버에서 전송된 데이터 수신
		byte[] buff = new byte[100];
		int len = is.read(buff);
		String receive_data = new String(buff,0,len);
		System.out.printf("(클라이언트)에코메세지 : %s\n",receive_data);
	}

}
