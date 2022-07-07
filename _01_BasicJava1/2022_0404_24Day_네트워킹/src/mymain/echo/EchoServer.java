package mymain.echo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws Exception{
		
		//1. ServerSocket����
		ServerSocket server = new ServerSocket(7000);
		
		System.out.println("---���� ���� �����---");
		
		while(true) {
			
			//2. ���� ��� [Queue������� �ϳ��� ������ ����Ѵ�]
			Socket child = server.accept();
			
			//netstat -a : ���� ������� ��Ʈ Ȯ�� ����
			
			//2-1.���� IP
			InetAddress ia = child.getInetAddress();
			
			//3. ����/���Ž�Ʈ��
			InputStream is = child.getInputStream();
			OutputStream os = child.getOutputStream();
			
			//4. ������ ����
			byte[] buff = new byte[100];
			//len : ���ŵ� ������ ����
			int len = is.read(buff);//����޼ҵ�
			//System.out.println(len);
			String read_data = new String(buff,0,len);
			System.out.printf("(����)[%s]�κ��� ���� ������ : %s\n",ia.getHostAddress(),read_data);
			
			//5. Ŭ���̾�Ʈ���� ������
			os.write(read_data.getBytes());
			
		}
		
	}

}
