package mymain;

import java.util.*;

public class _07_�Ϲݳ����������� {

	public static void main(String[] args) {
		// [���������� �� && ���]
		// ���Ʊ� : 0~6
		// �Ƶ��� : 7~13
		// û�ҳ� : 14~19
		// û�� : 20~40
		// ��� : 41~70
		// ��� : 71~
		
		Scanner scanner = new Scanner(System.in);
		
		int age; 
		System.out.printf("���� : ");
		age = scanner.nextInt();
		
		if(age >= 0 && age <=6) System.out.printf("[%d��]�� [���Ʊ�]�� �ش��մϴ�.\n",age);
		
		if(age >= 7 && age <= 13) System.out.printf("[%d��]�� [�Ƶ���]�� �ش��մϴ�.\n",age);
		
		if(age >= 14 && age <= 19) System.out.printf("[%d��]�� [û�ҳ�]�� �ش��մϴ�.\n",age);
		
		if(age >= 20 && age <= 40) System.out.printf("[%d��]�� [û��]�� �ش��մϴ�.\n",age);
		
		if(age >= 41 && age <= 70) System.out.printf("[%d��]�� [���]�� �ش��մϴ�.\n",age);
		
		if(age > 70) System.out.printf("[%d��]�� [���]�� �ش��մϴ�.\n",age);
		
		scanner.close();
	}

}
