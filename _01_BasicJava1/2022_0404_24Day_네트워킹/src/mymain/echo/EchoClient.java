package mymain.echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoClient {

	public static void main(String[] args) throws Exception{

		//1. ���� ��û : localhost <- ���� IP
		Socket client = new Socket("localhost", 7000);
		System.out.println("--Ŭ���̾�Ʈ ���� ����--");
		
		//2. ����/���� ��Ʈ���� ���´�.
		OutputStream os = client.getOutputStream(); //����
		InputStream is = client.getInputStream();   //����
		
		//3. �޽��� ����
		String msg = "�ȳ��ϼ���";
		os.write(msg.getBytes());
		
		//4. �������� ���۵� ������ ����
		byte[] buff = new byte[100];
		int len = is.read(buff);
		String receive_data = new String(buff,0,len);
		System.out.printf("(Ŭ���̾�Ʈ)���ڸ޼��� : %s\n",receive_data);
	}

}
