package mymain.multichat_serial;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;

//����ȭ ���ɰ�ü : ǥ��
public class Data implements Serializable{

	//protocol���
	public static final int IN    = 1;
	public static final int OUT   = 2;
	public static final int MSG   = 3;
	public static final int LIST  = 4;
	public static final int DRAW  = 5;
		
	int    protocol;  //����������
	String nickname;  //��ȭ��
	String message;   //�޽���
	
	//�����ڸ��
	String [] userArray;//�迭�� ����ȭ�ȴ�
	
	//�׸�������
	Point pt;    //��ǥ 
	int   thick; //������
	Color color; //������
	
	
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
