package myutil;

public class MyTime2 {
	private int hour;
	private int minute;
	private int second;

	//Constructor
	public MyTime2() {
		
	}

	public MyTime2(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}

	public MyTime2(int hour, int minute) {
		super();
		this.hour = hour;
		this.minute = minute;
	}

	public MyTime2(int hour) {
		super();
		this.hour = hour;
	}

	public int getHour() {
		return hour;
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
	
	
}
