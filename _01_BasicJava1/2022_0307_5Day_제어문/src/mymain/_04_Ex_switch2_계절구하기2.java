package mymain;

import java.util.Scanner;

public class _04_Ex_switch2_�������ϱ�2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int month;
		String season = "";
		
		System.out.print("�� : ");
		month = scanner.nextInt();
		
		//��ȿ�� �˻�
		if(month >= 1 && month <= 12) {
			/*
			switch(month) 
			{
				case 3: case 4:  case 5: season="��";     break;
				case 6: case 7:  case 8: season="����";   break;
				case 9: case 10: case 11: season= "����"; break;
				default : season="�ܿ�";
			}
			*/
			//���� ���ϱ�__���2
			switch(month/3) //������ Ȱ��
			{
				case 1: season="��";     break;
				case 2: season="����";   break;
				case 3: season= "����";  break;
				default : season="�ܿ�";
			}
		}else {
			System.out.println("���� 1~12���� ���� �Է��ϼ���.");
		}
		
		System.out.printf("[%d��]�� ������ [%s]�Դϴ�.",month,season);
		
		scanner.close();
	}

}
