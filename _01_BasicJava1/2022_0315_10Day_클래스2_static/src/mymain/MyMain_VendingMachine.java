package mymain;

import java.util.Scanner;

import myutil.VendingMachine;

public class MyMain_VendingMachine {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int money, drink;
		String yn = "Y";
		
		System.out.print("금액 : ");
		money = scanner.nextInt();
		VendingMachine v = VendingMachine.getInstance();
		v.insertCoin(money);
		
		do 
		{
			System.out.print("음료(1.콜라/2.사이다/3.쥬스/4.우유) : ");
			drink = scanner.nextInt();
			v.selectDrink(drink);
			v.displayResult();

			System.out.print("더 구매하실 건가요?(y/n) : ");
			yn = scanner.next();
		}while(yn.equalsIgnoreCase("Y"));
		
		scanner.close();
	}

}
