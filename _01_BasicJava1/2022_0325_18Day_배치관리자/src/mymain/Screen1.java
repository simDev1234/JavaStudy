package mymain;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Screen1 extends JPanel { 
	public Screen1() {
		this.setLayout(new BorderLayout()); //Panel�� �Ϲ������� Flow Layout�� ��
		
		JLabel label = new JLabel("ȭ��1");
		
		this.add(label,"Center");
		
		this.setBackground(Color.red);
	}
}
