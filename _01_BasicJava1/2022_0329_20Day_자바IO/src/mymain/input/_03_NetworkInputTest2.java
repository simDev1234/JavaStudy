package mymain.input;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class _03_NetworkInputTest2 {
	
	//�� html�� UTF-8�� ���ڸ� ���ڵ� 
	//---> �̰� ��Ŭ�������� ����(���� ��Ŭ���� MS949)
	//���ذ��� : ���ڽ�Ʈ������ ������ ��, CharsetName�� ���� �ִ´�. (Charset = ����������)

	public static void main(String[] args) throws Exception {
		String str_url = "https://www.naver.com/";
		
		URL url = new URL(str_url);
		
		InputStream is = url.openStream(); //���� ����� �����κ��� �����͸� �о�� �� �ִ� ��Ʈ��
		
		InputStreamReader isr = new InputStreamReader(is,"utf-8");
		
		int ch;
		//int count = 0;
		while(true) {
			//count++;
			//if(count>1000) break;
			ch = isr.read(); //�ѱ��ھ�
			if(ch==-1) break;
			System.out.printf("%c",ch);
		}
	}

}
