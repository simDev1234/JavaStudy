package mymain;

import myutil.Child;
import myutil.Parent;

public class MyMain_Child {

	public static void main(String[] args) {
		Parent p = new Child();
		
		p.sub(10);
		
		//Parent,sub() call -> Child.sub() call
		p.sub();
	}

}
