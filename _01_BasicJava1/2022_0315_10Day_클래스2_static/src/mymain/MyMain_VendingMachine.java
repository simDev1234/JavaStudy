package mymain;

import java.util.Scanner;

import myutil.VendingMachine;

public class MyMain_VendingMachine {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int money, drink;
		String yn = "Y";
		
		System.out.print("�ݾ� : ");
		money = scanner.nextInt();
		VendingMachine v = VendingMachine.getInstance();
		v.insertCoin(money);
		
		do 
		{
			System.out.print("����(1.�ݶ�/2.���̴�/3.�꽺/4.����) : ");
			drink = scanner.nextInt();
			v.selectDrink(drink);
			v.displayResult();

			System.out.print("�� �����Ͻ� �ǰ���?(y/n) : ");
			yn = scanner.next();
		}while(yn.equalsIgnoreCase("Y"));
		
		scanner.close();
	}

}
