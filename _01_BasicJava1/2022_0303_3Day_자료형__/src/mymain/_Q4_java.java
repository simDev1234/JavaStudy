package mymain;

import java.util.Scanner;

public class _Q4_java {
	public static void main(String[] args) {
		String name;
		int age;
		String addr;
		double length;
		double weight;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸� : ");
		name = scan.nextLine();
		System.out.print("���� : ");
		age = scan.nextInt();
		scan.nextLine();
		System.out.print("�ּ� : ");
		addr = scan.nextLine();
		System.out.print("Ű : ");
		length = scan.nextDouble();
		scan.nextLine();
		System.out.print("������ : ");
		weight = scan.nextDouble();
		scan.nextLine();
		
		System.out.println("---[�Է¹��� ����]---");
		System.out.printf("�̸� : %s\n���� : %d\n�ּ� : %s\nŰ : %.3f\n������ : %.3f\n",name,age,addr,length,weight);
	}
}
