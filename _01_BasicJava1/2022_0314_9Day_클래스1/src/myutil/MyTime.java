package myutil;

/*
 
  ������(Constructor) �޼ҵ�
  1. ��ü�� ������ �� ȣ��Ǵ� �޼ҵ�(�� 1ȸ��)
  2. ���� :  Ŭ�����̸�()
  3. ��ȯ���� ����.
  4. Ŭ������ �ʱ�ȭ ����� �����ϴ� �޼ҵ�
  5. Method Overload(�ߺ�����)�� ���� *�޼ҵ�� ����, �������� �ٸ�
  6. �������� : JVM�� �ڵ������ؼ� ó��
  
*/

public class MyTime {
	//Member Field : 
	//heap�޸𸮿����� ����
	  //�ڵ��ʱ�ȭ 
	  //���� : 0, ���� : false, �������� : Null;
	private int hour;
	private int minute;
	private int second;
	private static int[] arr = new int[3];
	
	//�ʱ�ȭ ��
	{
		hour = 2;
	}
	static {
		for(int i = 0; i <arr.length; i++) {
			arr[i] = i;
		}
	}
	
	//Default Constructor �⺻ ������
	public MyTime() {
		System.out.println("----MyTime()----");
		hour = minute = second = 1;
	}
	
	//Overload ������
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
	
	//�Ϲ� �޼���

	public void display() {
		System.out.printf("%02d:%02d:%02d%n",hour,minute,second);
	}
}
