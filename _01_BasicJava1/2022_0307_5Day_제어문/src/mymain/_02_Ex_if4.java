package mymain;

import java.util.Scanner;

public class _02_Ex_if4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int kor; //���� ��������
		String grade = "F"; //���(���� ���)
		System.out.print("���� : ");
		kor = scanner.nextInt();
		
		//��� ����
		
		if(kor>=0 && kor<=100) 
		{
			if(kor>=96) grade = "A+";
			else if(kor>=93) grade = "A";
			else if(kor>=90) grade = "A0";
			else if(kor>=86) grade = "B+";
			else if(kor>=83) grade = "B";
			else if(kor>=80) grade = "B0";
			else if(kor>=76) grade = "C+";
			else if(kor>=73) grade = "C";
			else if(kor>=70) grade = "C0";
			else if(kor>=66) grade = "D+";
			else if(kor>=63) grade = "D";
			else if(kor>=60) grade = "D0";
			else if(kor>=56) grade = "F+";
			else if(kor>=53) grade = "F";
			else if(kor>=50) grade = "F0";
		}
		else
		{
			System.out.printf("�Էµ� ���� [%d]�� ��ȿ���� �ʽ��ϴ�.",kor);
		}
		
		System.out.printf("�������� : %d(��) --> ��� : %s\n",kor,grade);
		
		scanner.close();
	}

}
