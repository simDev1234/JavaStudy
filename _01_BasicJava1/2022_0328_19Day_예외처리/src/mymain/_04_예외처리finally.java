package mymain;

import java.io.FileReader;
import java.io.IOException;

public class _04_����ó��finally {
	public static void main(String[] args) {
		
		FileReader fr = null;
		
		try {
			System.out.println("---Try---");
			fr = new FileReader("a.txt");
			//int res = 10/0;
		}catch(Exception e) {
			System.out.println("---Catch---");
		}finally { //���� �߻� ���ο� ������� ������ ����
			//System.out.println("---finally---"); 
			
			try {
				//ȭ���� ���� ������ �ݾƶ�
				if(fr!=null) fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
