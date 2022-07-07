package mymain;

public class MyMain_Ex_String2_불변적특징 {

	public static void main(String[] args) {
		
		//String 객체는 모든 연산시 또는 메소드 사용 시, 새로운 객체가 생성
		
		String str = "abc";
		//원래 객체를 이용하여 새로운 대문자 객체를 생성
		String str1 = str.toUpperCase();
		System.out.println(str);
		System.out.println(str1);
		
		String msg = "이 엑스야 죽을래";
		String msg1 = msg.replaceAll("엑스야", "**");
		//msg = msg.replaceAll("엑스야", "**");
		System.out.printf("[원본] : %s\n",msg);
		System.out.printf("[수정] : %s\n",msg1);
		
		String s = "잠깐";   //"잠깐" - 0x100 **쓰레기
		s = s + " 쉬었다가"; //"잠깐 쉬었다가" - 0x200 **쓰레기
		s = s + " 합니다.";  //"잠깐 쉬었다가 합니다." - 0x300
		System.out.println(s);
		
		/*
		String str2 = str;
		str2.toUpperCase(); <<--- 이걸 하게 되면 객체 또 생성됨
		*/
		
	}

}
