package mymain.multichat_serial;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

//직렬화 가능객체 : 표시
public class Data implements Serializable{

	//protocol상수
	public static final int IN    = 1;
	public static final int OUT   = 2;
	public static final int MSG   = 3;
	public static final int LIST  = 4;
	public static final int DRAW  = 5;
		
	int    protocol;  //데이터종류
	String nickname;  //대화명
	String message;   //메시지
	
	//접속자목록
	String [] userArray;//배열도 직렬화된다
	
	//그리기정보
	Point pt;    //좌표 
	int   thick; //선굵기
	Color color; //선색상
	
	
	public int getProtocol() {
		return protocol;
	}
	public void setProtocol(int protocol) {
		this.protocol = protocol;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String[] getUserArray() {
		return userArray;
	}
	public void setUserArray(String[] userArray) {
		this.userArray = userArray;
	}
	public Point getPt() {
		return pt;
	}
	public void setPt(Point pt) {
		this.pt = pt;
	}
	public int getThick() {
		return thick;
	}
	public void setThick(int thick) {
		this.thick = thick;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
		
	
	
}
