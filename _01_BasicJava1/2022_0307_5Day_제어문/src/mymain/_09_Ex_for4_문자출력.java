package mymain;

public class _09_Ex_for4_������� {

	public static void main(String[] args) {
		
		//A���� Z���� ���
		//A : 65 ~ Z : 90
		
		/* for(int i = 65; i <= 90; i++) */
		//���1. 
		//A,B...���� ��� --> ASCII�ڵ� 65,66...
		//int���� 4byte = charater���� 2byte. **�ݴ��� ���, ���� ���ɼ�
		for(int i = 'A'; i <= 'Z'; i++)
		{
			System.out.printf("%c",i);
		}
		System.out.println();
		
		//���2. 'A'+0, 'A'+1, 'A'+2...
		for(int i = 0; i < 26; i++)
		{
			System.out.printf("%c",'A'+i); 
	        //��¸޼��忡��, %c�� ������ ���� �� ����, %d�� 'A'�� ���� �� ����
		}
		System.out.println();
		
		
		//AbCdEf...���
		//A = 65, a = 97 //�빮�� - �ҹ��� = 32
		//A(b)C(d)E(f)... 65 (66) 67 (68) 69 (70)... Ȧ (¦) Ȧ (¦)...
		for(int i = 'A'; i <= 'Z'; i++)
		{
			if(i % 2 == 1)
				System.out.printf("%c",i);
			else
				System.out.printf("%c",i+32);
		}
		System.out.println();
		
		//AbcDefGhiJ...
		//0123456789.. i�� 3�� ����� �� 
		for(int i = 0; i < 26; i++)
		{
			if(i % 3 == 0)
				System.out.printf("%c",'A'+i);
			else
				System.out.printf("%c",'a'+i);
		}
		System.out.println();
		
		//ABC-DEF-GHI-....
		//012-345-678  
		char delim = '-';
		for(int i = 0; i < 26; i++)
		{
			if(i % 3 == 2)
				System.out.printf("%c%c",'A'+i,delim);
			else
				System.out.printf("%c",'A'+i);
		}
		System.out.println();

		//���� ������ �ڵ�
		/*
		for(int i = 0; i < 26; i++)
		{
			System.out.printf("%c",'A'+i);
			
			if(i % 3 == 2)
				System.out.print('-');
		}
		System.out.println(); 
		*/
	}

}
