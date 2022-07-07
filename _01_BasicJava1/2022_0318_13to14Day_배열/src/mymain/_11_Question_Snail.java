package mymain;

import java.util.Scanner;
import myutil.Snail;

public class _11_Question_Snail {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int chasu;
		String yn = "y";
		Snail snail = new Snail();
		
		while(true) {
			System.out.print("차수 : ");
			chasu = scanner.nextInt();
						
			//달팽이 객체 - 차수 전달(setter)
			snail.setChasu(chasu);
			//달팽이 출력
			
			//또?
			System.out.print("또?(y/n) : ");
			yn = scanner.next();
			if(!yn.equalsIgnoreCase("y")) break;
		}//end while
		
		System.out.println("----END----");
		scanner.close();
	}//end main
	
}