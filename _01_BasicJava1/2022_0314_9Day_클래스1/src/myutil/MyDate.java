package myutil;

public class MyDate {
	//�ɹ����� (Member Field) : �Ϲ������� ��ü���� ���α׷����� ����� ���� ��Ģ���� ��
	public int year;
	protected int month;
	private int day;
	char weekday;
	private String week = "�Ͽ�ȭ�������";
	
	//Setter �޼ҵ�
	public void setMonth(int month) {
		this.month = month;
		return; //��������
	}
	public void setDay(int day) {
		this.day = day;
	}
	public char setWeekday(int weekday) {
		this.weekday = week.charAt(weekday);
		return this.weekday;
	}
	
	//Getter �޼ҵ�
	public int getMonth() {return month;}
	public int getDay() {return day;}
	public char getWeekday() {return weekday;}
	
	//�Ϲ� �޼ҵ�
	public void display() {
		System.out.printf("%d�� %d�� %d��%n",year,month,day);
	}
	public void display1() {
		System.out.printf("%4d-%02d-%02d%n",year,month,day);
	}
}
