package mymain;

import myutil.BaseCalc;
import myutil.BaseCalcmpl;

public class MyMain_BaseCalc {
	public static void main(String[] args) {
		System.out.println(BaseCalc.PI);
		
		//The final field BaseCalc.PI cannot be assigned
		//BaseCalc.PI = 3.14;
		
		//설명서(명세목록)        설계서
		//                          공장(factory) **팩토리패턴
		BaseCalc calc = new BaseCalcmpl();
		int a = 10, b =2, res;
		res = calc.plus(a,b);
		System.out.printf("%d + %d = %d\n",a,b,res);
	}
}
