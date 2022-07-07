package mymain;

import myutil.MySingleTon2;

public class MyMain_SingleTon2 {

	public static void main(String[] args) throws InterruptedException {
		
		while(true) {
			MySingleTon2 singleton = MySingleTon2.getInstance();
			singleton.push_nail();
			
			Thread.sleep(2000);
		}
		
	}

}
