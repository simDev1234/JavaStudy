package myutil;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	int[] user_no; //사용자 번호
	int[] win_no;  //추첨 번호
	int count = 0; //맞은 갯수(보너스 제외)
	int bonus = 0;
	int rank;
	
	public void setUser_no(int[] user_no) {
		this.user_no = user_no;
		Arrays.sort(user_no);
		make_rank();
	}

	public void makeWinNo() {
		Random random = new Random();
		win_no = new int[7];
		
		int su = 0;
		OUTER : 
		for(int i = 0; i < win_no.length; i++) {
			su = random.nextInt(45)+1;
			
			//중복수 체크
			for(int j = 0; j < i; j++) {
				if(win_no[j]==su) {
					i--;
					continue OUTER;
				}
			}
			
			win_no[i] = su;
		}
		
		//마지막 번호를 제외한 앞 6자리 오름차순으로 선택정렬
		Arrays.sort(win_no, 0, 6);
	}
	
	//추첨결과 출력
	public void display() {
		System.out.println("----------[추첨 결과]----------");
		
		//[Win_no]
		System.out.print("추첨 번호 : ");
		for(int i = 0; i < win_no.length-1; i++) {
			System.out.printf("%3d", win_no[i]);
		}
		//보너스번호 
		System.out.printf(" (%d)\n",win_no[6]);
		
		//[User_no]
		System.out.print("유저 번호 : ");
		for(int i = 0; i < user_no.length; i++) {
			System.out.printf("%3d", user_no[i]);
		}
		System.out.println();
		
		//[등수 출력]
		//1등 : 6개 일치, 2등 : 5개 일치 + 보너스, 3등 : 5개 일치, 4등 : 4개 일치, 5등 : 3개
		System.out.print("당첨여부 : ");
		if(count >= 6 && bonus != 1) {
			rank = 1;
		}else if(count >= 5 && bonus ==1) {
			rank = 2;
		}else if(count >= 5 && bonus != 1){
			rank = 3;
		}else  if(count >= 4) {
			rank = 4;
		}else if(count >= 3) {
			rank = 5;
		}else {
			System.out.print("꽝!");
		}
		if(rank<=5)
			System.out.printf("%d등",rank);
	}
	
	private void make_rank() {
		//count,bonus초기화
		if(count > 0 || bonus > 0) {
			this.count = 0;
			this.bonus = 0;
		}
		//1등 : 6개 일치, 2등 : 5개 일치 + 보너스, 3등 : 5개 일치, 4등 : 4개 일치, 5등 : 3개
		for(int i = 0; i < user_no.length; i++) {
			for(int j = 0; j < win_no.length; j++) {
				if(j < win_no.length-1) {
					if(user_no[i]==win_no[j])
					count++;
				}else {
					if(user_no[i]==win_no[j])
					bonus++;
				}
			}
		}
	}
}
