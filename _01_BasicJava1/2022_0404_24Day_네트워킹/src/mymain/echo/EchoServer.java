package mymain.echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws Exception{
		
		//1. ServerSocket생성
		ServerSocket server = new ServerSocket(7000);
		
		System.out.println("---서버 접속 대기중---");
		
		while(true) {
			
			//2. 접속 대기 [Queue방식으로 하나씩 접속을 대기한다]
			Socket child = server.accept();
			
			//netstat -a : 현재 사용중인 포트 확인 가능
			
			//2-1.상대방 IP
			InetAddress ia = child.getInetAddress();
			
			//3. 전송/수신스트림
			InputStream is = child.getInputStream();
			OutputStream os = child.getOutputStream();
			
			//4. 데이터 수신
			byte[] buff = new byte[100];
			//len : 수신된 데이터 길이
			int len = is.read(buff);//동기메소드
			//System.out.println(len);
			String read_data = new String(buff,0,len);
			System.out.printf("(서버)[%s]로부터 수신 데이터 : %s\n",ia.getHostAddress(),read_data);
			
			//5. 클라이언트에게 재전송
			os.write(read_data.getBytes());
			
		}
		
	}

}
