package myutil;

import java.util.Calendar;

public class MyTime3 {
	private int hour;
	private int minute;
	private int second;

	//Constructor
	public MyTime3() {
		//���� �ý��� ��¥
		Calendar c = Calendar.getInstance();
		hour = c.get(Calendar.HOUR_OF_DAY); //24�ð�
		minute = c.get(Calendar.MINUTE);
		second = c.get(Calendar.SECOND);
	}
	public MyTime3(int hour) {
		this(); //this() : ���� �� Ŭ������ ������ 
		        //�������� ù�ٿ��� �ݵ�� this(); �Ǵ� super();�� �����Ѵ�. 
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
	
	//�Ϲ� �޼���
	public void display() {
		System.out.printf("%02d:%02d:%02d%n",hour,minute,second);
	}
}
