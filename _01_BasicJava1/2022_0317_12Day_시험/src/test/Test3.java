package test;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�̸� : ");
		String name = scanner.next();
		
		System.out.print("���� : ");
		int age = scanner.nextInt();
		
		scanner.nextLine();
		
		System.out.print("�ּ� : ");
		String addr = scanner.nextLine();
		
		System.out.print("���� : ");
		double height = scanner.nextDouble();
		
		System.out.print("ü�� : ");
		double weight = scanner.nextDouble();
		
		System.out.println("===[��������]===");
		System.out.printf("�̸� : %s\n",name);
		System.out.printf("���� : %d(��)\n",age);
		System.out.printf("�ּ� : %s\n",addr);
		System.out.printf("���� : %.1f(cm)\n",height);
		System.out.printf("ü�� : %.1f(kg)\n",weight);
		
		scanner.close();
	}

}
