package mymain;

public class MyMain_static초기화 {
	
	//초기화
	static {
		System.out.println("----0. 무슨 소리, 내가 먼저 수행된다.----");
		//main경기가 시작되기 전에 사전작업
		System.out.println("----1) Database Driver Load ----");
		System.out.println("----2) 각종 Resource(컴파일 필요없는 소스(image,sound...))");
	}

	public static void main(String[] args) {
		System.out.println("----1. 내가 제일 먼저 수행 돼!----");
	}

}

