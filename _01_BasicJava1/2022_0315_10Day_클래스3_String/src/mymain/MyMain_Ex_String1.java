package mymain;

public class MyMain_Ex_String1 {

	public static void main(String[] args) {
		//String 객체 생성 방법
		//1. 암시적 방법 : 상수 Pool(클래스영역에 있음)에 메모리공간 할당
		String name = "";
		//2. 명시적 방법 : Heap영역에 인스턴스가 형성되어 문자열 저장
		String s = new String("Hello");
		
		//문자열 비교
		
		//1. 암시적 방법
		String s1 = "Twinkle"; //java가 자주쓰는 문자열로 간주
		String s2 = "Twinkle"; //constant pool에 이 문자열을 넣고, s1과 s2가 참조하게 함
		                       //(항상 그렇지는 않음)
		if(s1 == s2)
			System.out.println("---SAME---");
		else
			System.out.println("---Diff---");
		
		
		//2. 명시적 방법
		String s3 = new String("Little Star");
		String s4 = new String("Liitle Star");
		
		if(s3 == s4)
			System.out.println("---SAME---");
		else
			System.out.println("---Diff---");
	}

}																																																														
