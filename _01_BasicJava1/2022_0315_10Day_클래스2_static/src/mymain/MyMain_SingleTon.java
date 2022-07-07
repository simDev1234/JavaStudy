package mymain;

import myutil.MySingleTon;

public class MyMain_SingleTon {

	public static void main(String[] args) throws InterruptedException {
		
		while(true) {
			//외부에서 서비스 요청이 들어왔다고 가정
			MySingleTon singleton = new MySingleTon();
			singleton.push_nail();
			
			Thread.sleep(2000);
		}
		//인스턴스만들고,못박고 계속 
		//--> C언어 : 개발자가 메모리누수고려해서 해제(free())
		//--> 자바  : 가비지 컬렉터에서 메모리 해제 --- 느리다. 실행할 때 중간에 가비지 컬렉터가 끼어들어서 
		
		
	}

}
