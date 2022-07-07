package mymain;

import myutil.Save;

public class MyMain_Save {
    //프로그램 시작시에 main함수 시작되어야 하므로, static으로
	public static void main(String[] args) {
		//static변수는 객체 생성하지 않고 사용 가능
		//클래스명.변수명
		//클래스변수
		Save.rate = 0.1;
		//Save.money = 10000; <-- warning!
		
		Save s1 = new Save("일길동",1000000);
		Save s2 = new Save("이길동",2000000);
		Save s3 = new Save("삼길동",3000000);
		
		System.out.printf("----[이율 : %.0f%%]----\n",Save.rate*100);
		s1.display();
		s2.display();
		s3.display();
		
		//static변수는 공유변수(각 객체가 모두 이용할 수 있다.)
		//s1.rate = 0.15; <-- 써도 되고 실행은 가능하나 warning! 
		Save.rate = 0.15;
		System.out.printf("----[이율 : %.0f%%]----\n",Save.rate*100);
		s1.display();
		s2.display();
		s3.display();
	}

}
