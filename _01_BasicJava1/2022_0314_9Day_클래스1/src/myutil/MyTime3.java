package myutil;

import java.util.Calendar;

public class MyTime3 {
	private int hour;
	private int minute;
	private int second;

	//Constructor
	public MyTime3() {
		//현재 시스템 날짜
		Calendar c = Calendar.getInstance();
		hour = c.get(Calendar.HOUR_OF_DAY); //24시간
		minute = c.get(Calendar.MINUTE);
		second = c.get(Calendar.SECOND);
	}
	public MyTime3(int hour) {
		this(); //this() : 지금 이 클래스의 생성자 
		        //생성자의 첫줄에는 반드시 this(); 또는 super();가 들어가야한다. 
		this.hour = hour;
	}
	/*
	public MyTime3(int hour) {
		this.hour = hour;
		Calendar c = Calendar.getInstance();
		minute = c.get(Calendar.MINUTE);
		second = c.get(Calendar.SECOND);
	}
	*/
	public MyTime3(int hour,int minute) {
		this(hour);
		this.minute = minute;
	}
	
	//Getter/Setter Method
	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}
	
	//일반 메서드
	public void display() {
		System.out.printf("%02d:%02d:%02d%n",hour,minute,second);
	}
}
