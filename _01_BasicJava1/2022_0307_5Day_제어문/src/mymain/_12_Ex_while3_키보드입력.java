package mymain;

import java.io.IOException;

public class _12_Ex_while3_Ű�����Է� {

	public static void main(String[] args) throws IOException {
		//Ű���� ǥ����ġ�� : System.in (byte�� �Է�)
		  //����ڰ� ���� ���� �� ���� - �����ڴ� �ݺ�Ƚ�� �� �� ����
		
		int ch;
		int count = 0; //�� �Է� ���ڼ�
		
		System.out.println("���� �Է��ϼ���(���� : Ctrl + Z)");
		
		while(true)
		{
			ch = System.in.read(); //Ű���� ���۷κ��� 1byte�� ����(Ű������۴� OS���� ó���ϴ� 1byte�̰�, �ڹٷ� ������ ���� 2byte. �ڹ��� �ڷ����� �� char�� 2byte)
								   //�����ö� int��
			if(ch == -1) break; //Ctrl+Z�϶�, read�޼ҵ尡 -1�� ��ȯ
			
			count++;
			
			System.out.printf("%c",ch);
		}
		System.out.printf("�Է��� ���ڼ� : %d\n",count);
		System.out.println("-----[END]-----");
		
		//white���� : ������ Ȯ���� �� ���� ����(\r,\n,\t,'')
	}

}
