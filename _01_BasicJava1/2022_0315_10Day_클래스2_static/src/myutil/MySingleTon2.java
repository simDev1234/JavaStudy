package myutil;

public class MySingleTon2 {
	
	//sigle-ton pattern
	//single : 자기 자신의 객체 주소를 저장할 수 있는 참조변수 
	//static : 프로그램 시작하면 만들어짐. 하나만 만들어짐
	static MySingleTon2 single = null;
	public static MySingleTon2 getInstance() {
		//없으면 생성해라
		if(single == null)
			single = new MySingleTon2();
		
		//2회 호출이후부터 기존생성객체정보 반환
		return single;
	}
	
	//외부에서 생성못하도록
	private MySingleTon2(){
		System.out.println("--MySingleTon()--");
	}
	
	public void push_nail() {
		System.out.println("--못박기--");
	}
}
