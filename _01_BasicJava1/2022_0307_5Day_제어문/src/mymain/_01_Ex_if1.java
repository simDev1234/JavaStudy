package mymain;

import java.util.Scanner;

public class _01_Ex_if1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int kor; //���� ��������
		String grade="ABCDF"; //���
		char result = 'F'; //���(���� ���)
		System.out.print("���� : ");
		kor = scanner.nextInt();
		
		//��� ���
		//A : 90-100
		//B : 80-89
		//C : 70-79
		//D : 60-69
		//F : 60�̸�
		
		
		//��ȿ���� �ڵ� : ������� �ʾƵ� �Ǵ� �ڵ� ���� 
		
		if(kor>=90 && kor <= 100) {
			result = grade.charAt(0);
		}
		if(kor>=80 && kor <90) {
			result = grade.charAt(1);
		}
		if(kor>=70 && kor <80) {
			result = grade.charAt(2);
		}
		if(kor>=60 && kor <70) {
			result = grade.charAt(3);
		}
		
		
		System.out.printf("�������� : %d(��) --> ��� : %c\n",kor,result);
		
		scanner.close();
	}

}
