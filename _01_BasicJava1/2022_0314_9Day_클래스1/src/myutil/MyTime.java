package myutil;

/*
 
  생성자(Constructor) 메소드
  1. 객체가 생성될 때 호출되는 메소드(단 1회만)
  2. 형식 :  클래스이름()
  3. 반환형이 없다.
  4. 클래스의 초기화 기능을 수행하는 메소드
  5. Method Overload(중복정의)가 가능 *메소드명 동일, 인자정보 다름
  6. 생략가능 : JVM이 자동생성해서 처리
  
*/

public class MyTime {
	//Member Field : 
	//heap메모리영역에 생성
	  //자동초기화 
	  //숫자 : 0, 논리형 : false, 참조변수 : Null;
	private int hour;
	private int minute;
	private int second;
	private static int[] arr = new int[3];
	
	//초기화 블럭
	{
		hour = 2;
	}
	static {
		for(int i = 0; i <arr.length; i++) {
			arr[i] = i;
		}
	}
	
	//Default Constructor 기본 생성자
	public MyTime() {
		System.out.println("----MyTime()----");
		hour = minute = second = 1;
	}
	
	//Overload 생성자
	public MyTime(int hour,int minute,int second) {
		System.out.println("----MyTime(int hour,int minute,int second)----");
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	//Getter, Setter
	public int getHour() {
		return hour;
	}

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
	
	public static int[] getArr() {
		return arr;
	}
	public static void setArr(int[] arr) {
		MyTime.arr = arr;
	}
	
	//일반 메서드

	public void display() {
		System.out.printf("%02d:%02d:%02d%n",hour,minute,second);
	}
}
