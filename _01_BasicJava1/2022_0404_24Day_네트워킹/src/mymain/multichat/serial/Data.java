package mymain.multichat.serial;

import java.awt.Point;
import java.io.Serializable;

public class Data implements Serializable{
	//protocol 상수
	public static final int IN = 1;
	public static final int OUT = 2;
	public static final int MSG = 3;
	public static final int LIST = 4;
	public static final int DRAW = 5;
	
	int protocol; //데이터의 종류
	String nickname; //대화명
	String message; //메시지
	
	//접속자 목록
	String[] userArray;
	
	//그리기 정보
	Point pt;
	int thick;
	int color;
	
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
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}

	
	
}
