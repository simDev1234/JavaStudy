package mymain;

import java.util.Scanner;

public class Q1_moneyCnt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int input;
		int tmp;
		int[] moneyArr = {50000, 10000, 5000, 1000, 500, 100, 50, 10}; 
		int[] cntArr = new int[9];
		
		//사용자에게 금액 받기
		System.out.print("금액 : ");
		input = tmp = scanner.nextInt();
		
		//화폐 갯수 세기 : 5만권부터 /와 % 연산자로 갯수 세기
		for(int i = 0; i < moneyArr.length; i++) {
			cntArr[i] = tmp / moneyArr[i];
			tmp = tmp % moneyArr[i];
		}
		
		System.out.printf("---%d(원)에 대한 권종별 갯수---\n",input);
		System.out.printf("50000원 : %d(매)\n",cntArr[0]);
		System.out.printf("10000원 : %d(매)\n",cntArr[1]);
		System.out.printf(" 5000원 : %d(매)\n",cntArr[2]);
		System.out.printf(" 1000원 : %d(매)\n",cntArr[3]);
		System.out.printf("  500원 : %d(개)\n",cntArr[4]);
		System.out.printf("  100원 : %d(개)\n",cntArr[5]);
		System.out.printf("   50원 : %d(개)\n",cntArr[6]);
		System.out.printf("   10원 : %d(개)\n",cntArr[7]);
		System.out.printf("    1원 : %d(개)\n",cntArr[8]);
		
		scanner.close();
	}

}
