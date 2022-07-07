package mymain;

import myutil.고등학생;
import myutil.중학생;
import myutil.초등학생;
import myutil.학생;

public class MyMain_학생 {
	
	public static void 어머니왈(학생[] studentArr) {
		for(int i =0; i < studentArr.length; i++) {
			학생 student = studentArr[i];
			
			//다형성(Polymorphism) : 전달 명령은 동일하나 처리는 명령을 받는 개체마다 다르다.
			//학생이니까 공부해라...(초등학생이니까 X)
			student.공부한다();
		}
	}

	public static void main(String[] args) {
		
		학생[] studentArr = {
							new 초등학생(), 
							new 중학생(), 
							new 고등학생()
							};
		어머니왈(studentArr);
		
	}//end main()

}//end MyMain_학생
