package mymain.input;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class _03_NetworkInputTest3 {
	
	//BufferedReader�� �� �� �� ������
	//���ۿ� �̸� �����͸� �޾Ƶΰ�, ���� �� �� �پ� �о��
	//�������(�д� �ӵ��� �� ����)

	public static void main(String[] args) throws Exception {
		String str_url = "https://www.naver.com/";
		
		URL url = new URL(str_url);
		
		InputStream is = url.openStream(); //���� ����� �����κ��� �����͸� �о�� �� �ִ� ��Ʈ��
		
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		
		BufferedReader bsr = new BufferedReader(isr);
		
		//int ch;
		//int count = 0;
		while(true) {
			
			String readStr = bsr.readLine();//1�پ� ����(Enter�� ����)
			if(readStr==null) break;
			System.out.println(readStr); //Enter�����ϱ� println���� ����ؾ���
			
			Thread.sleep(1000);
			
			//count++;
			//if(count>1000) break;
			//ch = isr.read(); //�ѱ��ھ�
			//if(ch==-1) break;
			//System.out.printf("%c",ch);
		}
	}

}
