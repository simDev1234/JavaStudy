package mymain;

import java.util.Scanner;
import myutil.Lotto;

public class _05_MyMain_Lotto {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Lotto lotto = new Lotto();
		
		//User input : 로또 번호 입력
		int[] user_no = new int[6];
		String yn = "Y";
		
		//추첨 실행
		lotto.makeWinNo();
		
		while(true) {
			System.out.print("숫자 6개를 입력하세요(1~45사이 숫자) : ");
			
			user_no[0] = scanner.nextInt();
			user_no[1] = scanner.nextInt();
			user_no[2] = scanner.nextInt();
			user_no[3] = scanner.nextInt();
			user_no[4] = scanner.nextInt();
			user_no[5] = scanner.nextInt();
			
			
			//로또 객체에게 입력 번호를 전달
			lotto.setUser_no(user_no);
			
			
			//로또 객체에서 당첨여부 확인 후 결과 출력
			lotto.display();
			
			//또?
			System.out.print("또 할래? (y/n) : ");
			yn = scanner.next();
			
			if(yn.equalsIgnoreCase("y")==false) break;
		}
		
		
		scanner.close();
	}

}
