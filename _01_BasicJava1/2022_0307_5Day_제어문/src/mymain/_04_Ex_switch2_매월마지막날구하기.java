package mymain;

import java.util.Scanner;

public class _04_Ex_switch2_�ſ������������ϱ� {
	public static void main(String[] args) {
		//�ſ� ������ ��¥�� ���ϴ� ���α׷�
		
		// 1   2   3   4   5   6   7   8   9   10   11   12
		// 31  28  31  30  31  30  31  31  30  31   30   31
		
		Scanner scanner = new Scanner(System.in);
		
		int month;
		int last_day = 31;
		
		System.out.print("�� : ");
		month = scanner.nextInt();
		
		//switch : ������ ����
		//��ȿ�� �˻�
		if(month>=1 && month<=12) {
			//�������� ���ϱ�
			switch(month) 
			{
				case 2: last_day=28; break;
				case 4: 
				case 6: 
				case 9: 
				case 11:last_day=30; break;
				default:last_day=31;
			}
		}else {
			System.out.println("���� 1~12���� ���� �Է��ϼ���.");
		}
		
		System.out.printf("[%d��]�� ���������� [%d��]�Դϴ�.",month,last_day);
		
		scanner.close();
	}

}
