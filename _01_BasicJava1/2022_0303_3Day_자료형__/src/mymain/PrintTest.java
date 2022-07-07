package mymain;

import java.util.Scanner;

public class PrintTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//콘솔창 입력 : 이름, 나이, 주소, 키, 몸무게
		System.out.print("이름 : ");
		String name = scan.nextLine();
		
		System.out.print("나이 : ");
		int age = scan.nextInt();
		scan.nextLine();
		
		System.out.print("주소 : ");
		String addr = scan.nextLine();
		
		System.out.print("키 : ");
		double height = scan.nextDouble();
		
		System.out.printf("몸무게 : ");
		double weight = scan.nextDouble();
		
		System.out.printf("기타 : ");
		double extra = scan.nextDouble();
		
		scan.close();
		
		//출력
		System.out.printf(" 이름 : %s\n",name);
		System.out.printf(" 나이 : %d\n",age);
		System.out.printf(" 주소 : %s\n",addr);
		System.out.printf("  키 : %.3f\n",height);
		System.out.printf("몸무게 : %.3f\n",weight);
		System.out.printf("기타 : %.3f\n",extra);
	}

}
