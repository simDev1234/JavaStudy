package mymain;

import myutil.MyMath2;

public class MyMain_MyMath2 {

	public static void main(String[] args) {
		int a = 3; 
		int b= 5;
		int res;
		//객체생성없이 사용 가능
		res = MyMath2.plus(a, b);
		
		
		
		
		//다른 영역
		res = MyMath2.plus(1, 2);
		
		
		res = Math.max(a, b);
	}

}
