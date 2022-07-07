package mymain;

import java.util.Scanner;

public class _Q2_java {

	public static void main(String[] args) {
		double radius; //반지름
		double circle_len; //원의 둘레
		double circle_area; //원의 면적

		Scanner scan = new Scanner(System.in);
		System.out.print("반지름을 입력하세요 : ");
		radius = scan.nextDouble();
		scan.close();
		
		circle_len = 2*(Math.PI)*radius;
		circle_area= radius*radius*(Math.PI);
		
		System.out.printf("반지름이 %.1f인 원의 둘레는 %.1f이며, 면적은 %.1f이다.",radius,circle_len,circle_area);
	}

}