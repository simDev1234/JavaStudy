package mymain;

import java.util.Scanner;

public class _02_Ex_if2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int kor; //���� ��������
		String grade="ABCDF"; //���
		char result = 'F'; //���(���� ���)
		System.out.print("���� : ");
		kor = scanner.nextInt();
		
		//��� ���
		//A : 90-100
		//B : 80-89
		//C : 70-79
		//D : 60-69
		//F : 60�̸�
		
		
		//�ڹٿ��� if, if else�� ����. 
		//�Ʒ�ó�� else�� �ɸ� ���ǿ� ���� else �������� ���� �� ����. 
		/*
		if(kor>=90 && kor <= 100) 
		{
			result = grade.charAt(0);
		}
		else 
		{
			if(kor>=80 && kor <90) 
				result = grade.charAt(1);
			if(kor>=70 && kor <80) 
				result = grade.charAt(2);
			if(kor>=60 && kor <70) 
				result = grade.charAt(3);
		}
		*/
		if(kor>=90 && kor <= 100) 
		{
			result = grade.charAt(0);
		}
		else 
		{
			if(kor>=80 && kor <90) 
			{	
				result = grade.charAt(1);
			}
			else 
			{
				if(kor>=70 && kor <80) 
				{
					result = grade.charAt(2);
				}
				else
				{
					if(kor>=60 && kor <70) 
					result = grade.charAt(3);
				}
			}	
		}
		
		
		System.out.printf("�������� : %d(��) --> ��� : %c\n",kor,result);
		
		scanner.close();
	}

}
