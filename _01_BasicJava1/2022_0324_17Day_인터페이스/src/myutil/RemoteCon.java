package myutil;

//interface다중상속 : 같은 종류 상속시 extends
public interface RemoteCon extends Volume,Channel{
	
	void onOff(); //전원
}
