package mymain;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		//1. 금액을 입력받는다.
		//2. 권종별 갯수를 구하기
		
		Scanner scanner = new Scanner(System.in);
		int money;
		int tmp;
		int cnt50000; //5만원권 갯수
		int cnt10000; //만원권 갯수
		int cnt5000; //5천원권 갯수
		int cnt1000; //천원권 갯수
		int cnt500; //500원 갯수
		int cnt100; //100원 갯수
		int cnt50; //50원 갯수
		int cnt10; //10원 갯수
		
		System.out.print("금액 입력 : ");
		tmp = money = scanner.nextInt();
		
		//5만원권 갯수 구하기
		cnt50000 = tmp / 50000;
		tmp = tmp % 50000;
		
		//만원권 갯수 구하기
		cnt10000 = tmp / 10000;
		tmp = tmp % 10000;
		
		//5천원권 갯수 구하기
		cnt5000 = tmp/5000;
		tmp = tmp % 5000;
		
		//천원권 갯수 구하기
		cnt1000 = tmp/1000;
		tmp = tmp % 1000;
		
		cnt500 = tmp/500;
		tmp = tmp % 500;
		
		cnt100 = tmp/100;
		tmp = tmp % 100;
		
		cnt50 = tmp/50;
		tmp = tmp % 50;
		
		cnt10 = tmp/10;
		tmp = tmp % 10;
		
		System.out.printf("---%d(원)에 대한 권종별 갯수---\n",money);
		System.out.printf("50000원권 : %d(매)\n",cnt50000);
		System.out.printf("10000원권 : %d(매)\n",cnt10000);
		System.out.printf("5000원권 : %d(매)\n",cnt5000);
		System.out.printf("1000원권 : %d(매)\n",cnt1000);
		System.out.printf("500원 : %d(개)\n",cnt500);
		System.out.printf("100원 : %d(개)\n",cnt100);
		System.out.printf("50원 : %d(개)\n",cnt50);
		System.out.printf("10원 : %d(개)\n",cnt10);
		System.out.printf("1원 : %d(개)\n",tmp);
		
		scanner.close();
		
	}

}
