package mymain;

import java.util.Scanner;

public class Q3_Bmi {

	public static void main(String[] args) {
		//BMI(ü���� ����) = ������/(Ű)^2(m)
		//20�̸� : ��ü��
		//20-24 : ����
		//25-29 : ��ü��
		//30 �̻� : ��
		
		double weight;
		double height;
		double height_m;
		double bmi;
		
		//����� �Է�
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("���� : ");
		height = scanner.nextDouble();
		height_m = height/100.0; //cm -> m
		
		System.out.print("ü�� : ");
		weight = scanner.nextDouble(); //kg
		
		//bmi������ ���� ��� ���
		bmi = weight/(height_m*height_m);
		/* bmi = weight/height_m*height_m ���� �� ���, 
		   �褼�� ���� ��Ÿ��
		*/
		
		if(bmi < 20) {
			System.out.printf("BMI : %.4f [��ü��]\n",bmi);
		} else if ( bmi > 20 &&  bmi <= 24) {
			System.out.printf("BMI : %.4f [����]\n",bmi);
		} else if ( bmi > 24 &&  bmi <= 29) {
			System.out.printf("BMI : %.4f [��ü��]\n",bmi);
		}else {
			System.out.printf("BMI : %.4f [��]\n",bmi);
		}
		
		scanner.close();
		
	}

}
