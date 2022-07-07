package mymain;

import javax.swing.JFrame;

public class BaseWin extends JFrame{
	
	public BaseWin() {
		super("");
		
		//위치             x   y
		super.setLocation(200,200);
		
		//크기
		super.setSize(400,400);

		//보여주기
		this.setVisible(true);
		
		//종료
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new BaseWin();
	}
}
