package mymain;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class _03_GridLayoutTest extends JFrame {

	public _03_GridLayoutTest() {
		super("");
		
		//Layout변경
		GridLayout gl = new GridLayout(3, 4);
		this.setLayout(gl);
		
		//GridLayout은 행우선으로 맞춰짐
		for(int i = 1; i <= 12; i++) {
			String title = String.format("%02d", i);
			JButton jbt = new JButton(title);
			this.add(jbt);
		}

		//위치             x   y
		super.setLocation(200, 200);

		//크기
		super.setSize(400, 400);

		//보여주기
		this.setVisible(true);

		//종료
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new _03_GridLayoutTest();
	}
}
