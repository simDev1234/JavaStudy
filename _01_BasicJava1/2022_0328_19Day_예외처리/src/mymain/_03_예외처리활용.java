package mymain;

import java.util.Scanner;

public class _03_예외처리활용 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int dan;
		
		while(true) {
			//이클립스 try-catch 단축키 : alt+shift+z
			try {
				System.out.printf("단:");
				dan = scanner.nextInt();
				
				if(dan < 2 || dan > 9) { //범위 벗어났을 때
					//System.out.println("2~9 사이의 숫자만 입력하세요.");
					//continue;
					throw new Exception();
				}
				for(int i = 1; i <= 9; i++) {
					System.out.printf("%d x %d = %d\n",dan,i,dan*i);
				}
			}catch (Exception e) { //숫자가 아닌 걸 입력했을 때
				//e.printStackTrace();
				System.out.println("2~9사이의 숫자만 입력해주세요.");
				scanner.nextLine();
			}
		}
	}
}
