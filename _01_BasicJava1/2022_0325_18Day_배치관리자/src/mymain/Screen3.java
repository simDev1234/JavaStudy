package mymain;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Screen3 extends JPanel { 
	public Screen3() {
		this.setLayout(new BorderLayout()); //Panel�� �Ϲ������� Flow Layout�� ��
		
		JLabel label = new JLabel("ȭ��3");
		
		this.add(label,"Center");
		
		this.setBackground(Color.blue);
	}
}
