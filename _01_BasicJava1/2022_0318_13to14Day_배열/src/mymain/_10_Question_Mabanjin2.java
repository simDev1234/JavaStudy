package mymain;

import java.util.Scanner;
import myutil.Mabanjin2;

public class _10_Question_Mabanjin2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int chasu;
		String yn = "y";
		Mabanjin2 mabanjin = new Mabanjin2();
		
		while(true) {
			System.out.print("차수 : ");
			chasu = scanner.nextInt();
			
			if(chasu%2==0) {
				System.out.println("홀수만 입력하세요.");
				continue;
			}
			
			//마방진 객체 - 차수 전달(setter)
			mabanjin.setChasu(chasu);
			//마방진 출력
			
			//또?
			System.out.print("또?(y/n) : ");
			yn = scanner.next();
			if(!yn.equalsIgnoreCase("y")) break;
		}//end while
		
		System.out.println("----END----");
		scanner.close();
	}//end main
	
}