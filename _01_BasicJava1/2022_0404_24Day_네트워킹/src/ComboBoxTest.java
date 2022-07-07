import java.awt.GridLayout;

import javax.swing.JFrame;

public class ComboBoxTest extends JFrame{
	
	ComboBoxTest(){
		setTitle("Chat");
		
		setLayout(new GridLayout(4,1));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new ComboBoxTest();
	}
}
