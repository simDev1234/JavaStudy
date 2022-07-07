package myutil;

public class MyDate {
	//맴버변수 (Member Field) : 일반적으로 객체지향 프로그램에서 숨기는 것을 원칙으로 함
	public int year;
	protected int month;
	private int day;
	char weekday;
	private String week = "일월화수목금토";
	
	//Setter 메소드
	public void setMonth(int month) {
		this.month = month;
		return; //생략가능
	}
	public void setDay(int day) {
		this.day = day;
	}
	public char setWeekday(int weekday) {
		this.weekday = week.charAt(weekday);
		return this.weekday;
	}
	
	//Getter 메소드
	public int getMonth() {return month;}
	public int getDay() {return day;}
	public char getWeekday() {return weekday;}
	
	//일반 메소드
	public void display() {
		System.out.printf("%d년 %d월 %d일%n",year,month,day);
	}
	public void display1() {
		System.out.printf("%4d-%02d-%02d%n",year,month,day);
	}
}
