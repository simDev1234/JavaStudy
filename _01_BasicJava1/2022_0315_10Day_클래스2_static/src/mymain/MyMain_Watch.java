package mymain;

import java.util.Calendar;

public class MyMain_Watch {

	public static void main(String[] args) throws InterruptedException {
		while(true) {
			Calendar c = Calendar.getInstance(); // Single-ton
			
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			int second = c.get(Calendar.SECOND);
			
			System.out.printf("%02d : %02d : %02d\n",hour,minute,second);
			
			Thread.sleep(1000);
		}
	}

}
