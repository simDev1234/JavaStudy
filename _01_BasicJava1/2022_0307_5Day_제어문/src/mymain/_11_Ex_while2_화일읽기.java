package mymain;

import java.io.FileReader;
//import java.io.IOException;

public class _11_Ex_while2_ȭ���б� {

	public static void main(String[] args) throws Exception {
		
		FileReader fr = new FileReader("a.txt"); //file ����
		
		int ch;
		int cnt = 0; //���ڰ���
		while(true)
		{
			//cnt++; <-- ���⿡ �� ���, �ݺ�Ƚ��
			/*
			 ������ ���� �ؽ�Ʈ : A, \r, \, B, (EOF) �� 5�� ����
			 
			 A\r\n
			 B(EOF)
			 */
			ch = fr.read(); //���� 1�� int�� �о����
			
			//EOF(End of File) - txt���Ͽ��� ���� ǥ���� �� -1�� ǥ��
			if(ch == -1) break; //break : �ݺ���, switch Ż�⹮
			
			cnt++; //EOF���� �� ���ڼ� -- 4��
			
			System.out.printf("%c",ch);
			//Thread.sleep(100);	
		}
		System.out.println("\r\ncnt : "+cnt);
		
		fr.close(); //file �ݱ� (���� ���α׷����� file�� ���ٰ����ϰ�)
		
		//������� ��, ��Ŭ�������� Run>Debug 
		//F5:step into - �޼ҵ� ������ ����
		//F6:step over - Toggle Breakpoint���� �ϳ��� �����ϱ�
	}

}
