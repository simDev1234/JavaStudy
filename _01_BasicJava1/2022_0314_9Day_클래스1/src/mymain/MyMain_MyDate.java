package mymain;

import myutil.MyDate;

public class MyMain_MyDate extends MyDate{

	public static void main(String[] args) {
		MyDate in = new MyDate();
		
		//**public(공개모드)
		in.year = 2022;
		
		//**protected(보호모드) : 상속받은 자식 또는 동일 패키지
		//in.month = 3;
		in.setMonth(3);
		
		//**private(비공개모드) : 자신 외에는 사용 못함
		//in.day = 14;
		in.setDay(14);
		
		//**default(생략) : 동일 패키지
		//in.weekday = 1;
		in.setWeekday(1);
		
		int month = in.getMonth();
		int day = in.getDay();
		char weekday = in.getWeekday();
		System.out.printf("오늘은 %d년 %d월 %d일 %c요일%n",in.year,month,day,weekday);
		
		in.display();
		in.display1();
	}

}
