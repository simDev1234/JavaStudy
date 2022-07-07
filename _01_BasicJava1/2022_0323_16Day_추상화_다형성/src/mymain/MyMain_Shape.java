package mymain;

import myutil.*;

public class MyMain_Shape {

	public static void main(String[] args) {
		Shape[] shapeArr = {new Circle(), new Nemo(), new Triangle()};
		Shape circle = shapeArr[0];
		circle.draw();
		Shape nemo  = shapeArr[1];
		nemo.draw();
		Shape triangle = shapeArr[2];
		triangle.draw();
	}

}
