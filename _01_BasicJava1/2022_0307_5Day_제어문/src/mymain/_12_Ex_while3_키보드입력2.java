package mymain;

import java.io.IOException;

public class _12_Ex_while3_Ű�����Է�2 {

	public static void main(String[] args) throws IOException {
		//Ű���� ǥ����ġ�� : System.in (byte�� �Է�)
		  //����ڰ� ���� ���� �� ���� - �����ڴ� �ݺ�Ƚ�� �� �� ����
		
		int ch;
		int total_count = 0; //�� �Է� ���ڼ�
		int number_count = 0; //���ڹ��� ����
		int alpha_upper_count = 0; //�빮�� ����
		int alpha_lower_count = 0; //�ҹ��� ����
		int white_count = 0; //white���� ���� : (\r,\n,\t,'')
		int etc_count = 0; //������ ���� ����
		
		System.out.println("���� �Է��ϼ���(���� : Ctrl + Z)"); 
		//�ü���� CL(��� ����)���� Ctrl+z�� ������ ����Ű
		
		while(true)
		{
			ch = System.in.read(); 
			
			if(ch == -1) break; //System.in.read()�� -1��ȯ
			
			//�� �Է� ���� ī��Ʈ(EOF ����)
			total_count++;

			//������ ���� ī��Ʈ
			if(ch >= '0' && ch <= '9') 
				number_count++;
			
			//�빮�� ���� ī��Ʈ
			else if(ch >= 'A' && ch <= 'Z') 
				alpha_upper_count++;
			
			//�ҹ��� ���� ī��Ʈ
			else if(ch >= 'a' && ch <= 'z') 
				alpha_lower_count++;
			
			//�ܹ��� ���� ī��Ʈ
			else if(ch == '\r' || ch == '\n' || ch == '\t'  || ch == ' ') 
				white_count++;
			
			//������ ���� ī��Ʈ
			else
				etc_count++;
			
			System.out.printf("%c",ch);
		}
		System.out.printf("��  ü ���� : %2d\n",total_count);
		System.out.printf("��  �� ���� : %2d\n",number_count);
		System.out.printf("�빮�� ���� : %2d\n",alpha_upper_count);
		System.out.printf("�ҹ��� ���� : %2d\n",alpha_lower_count);
		System.out.printf("ȭ��Ʈ ���� : %2d\n",white_count);
		System.out.printf("������ ���� : %2d\n",etc_count);
		System.out.println("-----[END]-----");
		
		
	}

}
