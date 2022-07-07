package mymain;

import java.util.ArrayList;

import myutil.AdvanceCalc;
import myutil.BaseCalc;

public class MyMain_Calc {
	
	//Up-Casting
	static void use_baseCalc(BaseCalc bc) {
		//input ) BaseCalc bc = ac;
		int x = 10, y = 5, res;
		res = bc.multiply(x, y);
		System.out.println("10 x 5 = "+res);
		//AdvanceCalc의 메소드 사용 불가
		//res = bc.hap(x);
	}
	
	//Down-Casting       : Up-casting
	static void use_object(Object ob) {
		//input ) Object ob = ac;
		System.out.println(ob.toString());
		/*
		//사용범위 넘어섬(Object(o), AdvanceCalc(x))
		int x = 10, res;
		res = ob.hap();
		*/
		int x = 10, res;//Down-casting(사용 영역 확장)
		AdvanceCalc ac = (AdvanceCalc)ob;
		res = ac.hap(x);
		System.out.printf("%d까지 합 = %d%n",x,res);
	}

	public static void main(String[] args) {
		AdvanceCalc ac = new AdvanceCalc();
		
		int a = 10, b = 3, res;
		
		res = ac.plus(a, b);
		System.out.printf("%d + %d = %d%n",a,b,res);
		
		res = ac.hap(a);
		System.out.printf("%d까지합 = %d%n",a,res);
		
		//use.basecalc이용
		use_baseCalc(ac);
		
		//use.object이용
		use_object(ac);
		
		Object obj = new Object();
		//use_object(obj); //실행시 casting 에러
				
		//Collection : 저장관리객체 <= 자바의 모든 객체(만) 저장 *Object타입으로 자동형변환
		//동적 배열
		ArrayList list = new ArrayList();
		list.add("자바 스트링 객체"); 
		list.add(10); //10(int) -> new Integer(10) *Auto-Boxing
		list.add(true); //      -> new Boolean(true)
		list.add(10.5); //      -> new Double(10.5)
		
		String s1 = (String)list.get(0);
		
		//Wrapper class(JDK 5.0)
		//Integer     int -> Integer로 바뀜(자동형변환)
		//Integer nOb = 10;
		//Auto-Boxing : 자바가 알아서 객체로 포장해서 넣어줌(JDK 5.0 Later)
		Integer nOb = new Integer(10);
		//Integer nOb2 = Integer.valueOf(10); //얘도 반환값이 new Integer(10)
		
		int n = nOb; //*Auto-Unboxing(자동해체)
		//int n = nOb.intValue();
		double d = nOb;
		//double d = nOb.doubleValue();
		float f = nOb;
		//float f = nOb.floatValue();
		long l = nOb;
		//long l = nOb.longValue();
		
		
		//배열에 저장될 때 Up-casint되면서 저장됨
		Object[] array = {new String("스트링"), new Integer(10), new Boolean(true), new Double(10.5)};
		
		//String s = array[0]; //에러 발생(array[0]은 Object타입)
		String s2 = (String)array[0]; //down-casting
		Integer n1 = (Integer)array[1];
	}

}
