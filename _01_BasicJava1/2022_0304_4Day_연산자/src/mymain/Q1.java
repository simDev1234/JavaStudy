package mymain;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		//1. �ݾ��� �Է¹޴´�.
		//2. ������ ������ ���ϱ�
		
		Scanner scanner = new Scanner(System.in);
		int money;
		int tmp;
		int cnt50000; //5������ ����
		int cnt10000; //������ ����
		int cnt5000; //5õ���� ����
		int cnt1000; //õ���� ����
		int cnt500; //500�� ����
		int cnt100; //100�� ����
		int cnt50; //50�� ����
		int cnt10; //10�� ����
		
		System.out.print("�ݾ� �Է� : ");
		tmp = money = scanner.nextInt();
		
		//5������ ���� ���ϱ�
		cnt50000 = tmp / 50000;
		tmp = tmp % 50000;
		
		//������ ���� ���ϱ�
		cnt10000 = tmp / 10000;
		tmp = tmp % 10000;
		
		//5õ���� ���� ���ϱ�
		cnt5000 = tmp/5000;
		tmp = tmp % 5000;
		
		//õ���� ���� ���ϱ�
		cnt1000 = tmp/1000;
		tmp = tmp % 1000;
		
		cnt500 = tmp/500;
		tmp = tmp % 500;
		
		cnt100 = tmp/100;
		tmp = tmp % 100;
		
		cnt50 = tmp/50;
		tmp = tmp % 50;
		
		cnt10 = tmp/10;
		tmp = tmp % 10;
		
		System.out.printf("---%d(��)�� ���� ������ ����---\n",money);
		System.out.printf("50000���� : %d(��)\n",cnt50000);
		System.out.printf("10000���� : %d(��)\n",cnt10000);
		System.out.printf("5000���� : %d(��)\n",cnt5000);
		System.out.printf("1000���� : %d(��)\n",cnt1000);
		System.out.printf("500�� : %d(��)\n",cnt500);
		System.out.printf("100�� : %d(��)\n",cnt100);
		System.out.printf("50�� : %d(��)\n",cnt50);
		System.out.printf("10�� : %d(��)\n",cnt10);
		System.out.printf("1�� : %d(��)\n",tmp);
		
		scanner.close();
		
	}

}
