package mymain;

import java.util.Scanner;

public class _08_�Ϲݳ�����������2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int year;
		System.out.print("���� : ");
		year = scanner.nextInt();
		
		//����/���
		//���� ����
		//����1. 400�� ����� �Ǵ� �� (ex.400��, 800��...2000��)
		//�Ǵ�
		//����2. 4�� ����̸鼭 100�� ����� �ƴ� �� 
		
		if((/*���� 1*/year%400==0) || (/*����2*/year%4==0 && year%100!=0)) {
			System.out.printf("[%d]�⵵�� [����]�Դϴ�.\n",year);
		}else {
			System.out.printf("[%d]�⵵�� [���]�Դϴ�.\n",year);
		}
		
		scanner.close();
	}

}
