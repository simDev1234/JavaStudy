package mymain;

import java.util.Scanner;

public class _05_Ex_switch3_���� {

	public static void main(String[] args) {
		//1.�������� �Է¹޴´�.
		//2. switch���� �̿��ؼ� ����� �����ϼ���.(ABCDF)--����Ȱ��(10��)
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���� ���� : ");
		int score = scanner.nextInt();
		char grade = 'F';
		
		//��ȿ�� Ȯ��
		if(score>=0 && score<=100) {
			//��޳���
			switch(score/10) 
			{
				case 10 : 
				case  9 : grade = 'A'; break;
				case  8 : grade = 'B'; break;
				case  7 : grade = 'C'; break;
				case  6 : grade = 'D'; break;
				default : grade = 'F';
			}
			
			System.out.printf("[%d]���� ��, ����� [%c]�Դϴ�.",score,grade);
			
		}else {
			System.out.println("��ȿ���� ���� ���Դϴ�.(0~100����)");
		}
		
		scanner.close();
	}

}
