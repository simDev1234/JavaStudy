package mymain;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class _01_BorderLayoutTest extends JFrame {

	public _01_BorderLayoutTest() {
		super("BorderLayout 연습");
		
		//버튼을 해당 위치에 배치
		JButton jbt_east = new JButton("East");
		JButton jbt_west = new JButton("West");
		JButton jbt_south = new JButton("South");
		JButton jbt_north = new JButton("North");
		JButton jbt_center = new JButton("Center");
		
		//BorderLayout -> 위치 지정
		this.add(jbt_east, "East");
		this.add(jbt_west,"West");
		this.add(jbt_west,BorderLayout.WEST);
		this.add("South",jbt_south);
		this.add(jbt_center); //위치 생략하면 기본 center
		this.add(jbt_north,"North");

		//위치             x   y
		super.setLocation(200, 200);

		//크기
		super.setSize(400, 400);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new _01_BorderLayoutTest();
	}
}
