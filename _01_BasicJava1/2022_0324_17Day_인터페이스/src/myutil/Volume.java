package myutil;

public interface Volume {
	//상수 
	int MIN = 0;
	int MAX = 30;
	
	//추상메소드
	void volumeUp();
	void volumeDown();
	void volumeZero();
}
