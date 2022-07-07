package mymain;

import java.util.Scanner;
import myutil.MyInfo;

public class _03_MethodEx3 {
	public static void main(String[] args) {
		
		int year;
		int age;
		double height;
		double weight;
		String tti;
		String ganji;
		
		Scanner scanner = new Scanner(System.in);
		MyInfo myinfo = new MyInfo();
		
		//user input : year
		System.out.print("����⵵(ex.1994) : ");
		year = scanner.nextInt();
		System.out.print("Ű(ex.180) : ");
		height = scanner.nextDouble();
		System.out.print("������(ex.66) : ");
		weight = scanner.nextDouble();
		
		//print age by year
		age = myinfo.getAge(year);
		System.out.printf("���� : %d��%n",age);
		
		//print Tti by year
		tti = myinfo.getTti(year);
		System.out.printf("�� : %s%n",tti);
		
		//print Ganji by year
		ganji = myinfo.getGanji(year);
		System.out.printf("���� : %s%n",ganji);
		
		//bmi ��ġ
		double bmi = myinfo.getBmi(height, weight);
		System.out.printf("BMI : %f%n",bmi);
		System.out.printf("BMI State : %s%n",myinfo.getBmiState(bmi));
		
		scanner.close();
	}
}
