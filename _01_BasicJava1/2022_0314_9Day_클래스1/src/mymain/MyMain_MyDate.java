package mymain;

import myutil.MyDate;

public class MyMain_MyDate extends MyDate{

	public static void main(String[] args) {
		MyDate in = new MyDate();
		
		//**public(�������)
		in.year = 2022;
		
		//**protected(��ȣ���) : ��ӹ��� �ڽ� �Ǵ� ���� ��Ű��
		//in.month = 3;
		in.setMonth(3);
		
		//**private(��������) : �ڽ� �ܿ��� ��� ����
		//in.day = 14;
		in.setDay(14);
		
		//**default(����) : ���� ��Ű��
		//in.weekday = 1;
		in.setWeekday(1);
		
		int month = in.getMonth();
		int day = in.getDay();
		char weekday = in.getWeekday();
		System.out.printf("������ %d�� %d�� %d�� %c����%n",in.year,month,day,weekday);
		
		in.display();
		in.display1();
	}

}
