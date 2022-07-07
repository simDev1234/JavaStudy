package mymain;

import java.util.Arrays;
import myutil.*;

import myutil.MyTime;

public class MyMain_MyTime {

	public static void main(String[] args) {
		MyTime m = new MyTime();
		m.display();
		MyTime m2 = new MyTime(3,5,12);
		m2.display();
		System.out.println(Arrays.toString(MyTime.getArr()));
		
		//MyTime3
		System.out.println();
		MyTime3 m3 = new MyTime3();
		m3.display();
		MyTime3 m4 = new MyTime3(2,3);
		m4.display();
		MyTime3 m5 = new MyTime3(4);
		m5.display();
	}

}
