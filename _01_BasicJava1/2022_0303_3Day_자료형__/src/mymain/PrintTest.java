package mymain;

import java.util.Scanner;

public class PrintTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//�ܼ�â �Է� : �̸�, ����, �ּ�, Ű, ������
		System.out.print("�̸� : ");
		String name = scan.nextLine();
		
		System.out.print("���� : ");
		int age = scan.nextInt();
		scan.nextLine();
		
		System.out.print("�ּ� : ");
		String addr = scan.nextLine();
		
		System.out.print("Ű : ");
		double height = scan.nextDouble();
		
		System.out.printf("������ : ");
		double weight = scan.nextDouble();
		
		System.out.printf("��Ÿ : ");
		double extra = scan.nextDouble();
		
		scan.close();
		
		//���
		System.out.printf(" �̸� : %s\n",name);
		System.out.printf(" ���� : %d\n",age);
		System.out.printf(" �ּ� : %s\n",addr);
		System.out.printf("  Ű : %.3f\n",height);
		System.out.printf("������ : %.3f\n",weight);
		System.out.printf("��Ÿ : %.3f\n",extra);
	}

}
