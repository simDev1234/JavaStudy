package mymain;

import java.util.Scanner;

public class _08_일반논리연산자응용2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		int year;
		System.out.print("연도 : ");
		year = scanner.nextInt();
		
		//윤년/평년
		//윤년 조건
		//조건1. 400의 배수가 되는 해 (ex.400년, 800년...2000년)
		//또는
		//조건2. 4의 배수이면서 100의 배수가 아닌 해 
		
		if((/*조건 1*/year%400==0) || (/*조건2*/year%4==0 && year%100!=0)) {
			System.out.printf("[%d]년도는 [윤년]입니다.\n",year);
		}else {
			System.out.printf("[%d]년도는 [평년]입니다.\n",year);
		}
		
		scanner.close();
	}

}
