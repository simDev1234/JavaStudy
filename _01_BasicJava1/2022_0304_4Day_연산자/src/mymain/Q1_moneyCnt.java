package mymain;

import java.util.Scanner;

public class Q1_moneyCnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int input;
		int tmp;
		int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10}; 
		int[] cntArr = new int[9];
		
		//����ڿ��� �ݾ� �ޱ�
		System.out.print("�ݾ� : ");
		input = tmp = scanner.nextInt();
		
		//ȭ�� ���� ���� : 5���Ǻ��� /�� % �����ڷ� ���� ����
		for(int i = 0; i < moneyArr.length; i++) {
			cntArr[i] = tmp / moneyArr[i];
			tmp = tmp % moneyArr[i];
		}
		
		System.out.printf("---%d(��)�� ���� ������ ����---\n",input);
		System.out.printf("50000�� : %d(��)\n",cntArr[0]);
		System.out.printf("10000�� : %d(��)\n",cntArr[1]);
		System.out.printf(" 5000�� : %d(��)\n",cntArr[2]);
		System.out.printf(" 1000�� : %d(��)\n",cntArr[3]);
		System.out.printf("  500�� : %d(��)\n",cntArr[4]);
		System.out.printf("  100�� : %d(��)\n",cntArr[5]);
		System.out.printf("   50�� : %d(��)\n",cntArr[6]);
		System.out.printf("   10�� : %d(��)\n",cntArr[7]);
		System.out.printf("    1�� : %d(��)\n",cntArr[8]);
		
		scanner.close();
	}

}
