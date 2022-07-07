package mymain;

import myutil.Animal;
import myutil.Cat;
import myutil.Dog;
import myutil.Pig;

public class MyMain_Animal {
	
	static void speak(Animal[] animalArr) {
		for(Animal animal : animalArr) {
			animal.cry();
			animal.eat();
		}
	}

	public static void main(String[] args) {
		Animal[] animalArr = {new Cat(), new Dog(), new Pig()};
		speak(animalArr);
	}

}
