package mymain;

import myutil.����л�;
import myutil.���л�;
import myutil.�ʵ��л�;
import myutil.�л�;

public class MyMain_�л� {
	
	public static void ��ӴϿ�(�л�[] studentArr) {
		for(int i =0; i < studentArr.length; i++) {
			�л� student = studentArr[i];
			
			//������(Polymorphism) : ���� ����� �����ϳ� ó���� ����� �޴� ��ü���� �ٸ���.
			//�л��̴ϱ� �����ض�...(�ʵ��л��̴ϱ� X)
			student.�����Ѵ�();
		}
	}

	public static void main(String[] args) {
		
		�л�[] studentArr = {
							new �ʵ��л�(), 
							new ���л�(), 
							new ����л�()
							};
		��ӴϿ�(studentArr);
		
	}//end main()

}//end MyMain_�л�
