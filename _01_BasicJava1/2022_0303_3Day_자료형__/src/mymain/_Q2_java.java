package mymain;

import java.util.Scanner;

public class _Q2_java {

	public static void main(String[] args) {
		double radius; //������
		double circle_len; //���� �ѷ�
		double circle_area; //���� ����

		Scanner scan = new Scanner(System.in);
		System.out.print("�������� �Է��ϼ��� : ");
		radius = scan.nextDouble();
		scan.close();
		
		circle_len = 2*(Math.PI)*radius;
		circle_area= radius*radius*(Math.PI);
		
		System.out.printf("�������� %.1f�� ���� �ѷ��� %.1f�̸�, ������ %.1f�̴�.",radius,circle_len,circle_area);
	}

}