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
		System.out.print("이름 : ");
		name = scan.nextLine();
		System.out.print("나이 : ");
		age = scan.nextInt();
		scan.nextLine();
		System.out.print("주소 : ");
		addr = scan.nextLine();
		System.out.print("키 : ");
		length = scan.nextDouble();
		scan.nextLine();
		System.out.print("몸무게 : ");
		weight = scan.nextDouble();
		scan.nextLine();
		
		System.out.println("---[입력받은 정보]---");
		System.out.printf("이름 : %s\n나이 : %d\n주소 : %s\n키 : %.3f\n몸무게 : %.3f\n",name,age,addr,length,weight);
	}
}
