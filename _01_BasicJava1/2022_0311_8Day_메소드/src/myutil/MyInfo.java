package myutil;

import java.util.Calendar;

// 1. ����⵵ �־�����
//    - ����(getAge() ), ��(getTti()), 60����(getGanji())
// 12�� : "��", "��", "ȣ����", "�䳢", "��", "��", "��", "��", "������", "��", "��", "����"
// 60���� : (����)���������������Ӱ� + (������)�����ι�������̽�������

public class MyInfo {
	
	//bmi��ġ�� ����ϱ� : ü��/Ű(m)^2 (��ȯŸ�� : double)
	public double getBmi(double height, double weight) {
		if(height >= 100) {height = height/100;}
		return weight/Math.pow(height, 2);
	}
	
	//bmi��ġ�� ���� ���(�Է� : double, ��ȯ Ÿ�� : String)
	public String getBmiState(double bmi) {
		if(bmi > 25) {
			return "��";
		}else if(bmi > 23) {
			return "��ü��";
		}else if(bmi > 18.5) {
			return "����";
		}else {
			return "��ü��";
		}
	}
	
	//���� ���� ���ϱ�
	public String getGanji(int year) {
		
		//���ʰ��� : �ʰ���+���̰���
		//�ʰ��� : 2022 % 10
		//���̰��� : 2022 % 12
		int gan = year % 10;
		int ji = year % 12;
		String result = "";
		
		switch(gan) {
			case  0 : result = "��"; break;
			case  1 : result = "��"; break;
			case  2 : result = "��"; break;
			case  3 : result = "��"; break;
			case  4 : result = "��"; break;
			case  5 : result = "��"; break;
			case  6 : result = "��"; break;
			case  7 : result = "��"; break;
			case  8 : result = "��"; break;
			default : result = "��"; break;
		}
		switch(ji) {
			case  0 : result += "��"; break;
			case  1 : result += "��"; break;
			case  2 : result += "��"; break;
			case  3 : result += "��"; break;
			case  4 : result += "��"; break;
			case  5 : result += "��"; break;
			case  6 : result += "��"; break;
			case  7 : result += "��"; break;
			case  8 : result += "��"; break;
			case  9 : result += "��"; break;
			case 10 : result += "��"; break;
			default : result += "��"; break;
		}
		
		return result+"��";
		
		//���2_���ڿ��� ������ ���� ���
		//String gan10 = "����Ӱ谩����������";
		//String ji12 = "�������������ι��������";
		//int gan = year % 10;
		//int ji = year % 12;
		//return ""+gan10.charAt(gan)+ji12.charAt(ji)+"��";
	}
	
	//�� ���ϱ�
	public String getTti(int year) {
		//��, ��, ��... ������ ��...
		// 4, 5,  6 ... 0       1
		// 0���� : "������", "��", "��", "����", "��", "��", "ȣ����", "�䳢", "��", "��", "��", "��"
		int tti_index = year % 12; //0~11�� ����
		switch(tti_index) {
			case  0 : return "������";
			case  1 : return "��";
			case  2 : return "��";
			case  3 : return "����";
			case  4 : return "��";
			case  5 : return "��";
			case  6 : return "ȣ����";
			case  7 : return "�䳢";
			case  8 : return "��";
			case  9 : return "��";
			case 10 : return "��";
			default : return "��";
		}
	}
	
	//���� ���ϱ�
	public int getAge(int year) {
		//���� �ý��� ��¥ ���ϱ�
		Calendar c = Calendar.getInstance();
		int current_year = c.get(Calendar.YEAR);
		//�� ���� �� (Calendar�� MONTH : 1�� = 0)
		//int current_month = c.get(Calendar.MONTH) + 1; 
		
		//���� = ����⵵ - ����⵵ + 1; 
		int age = current_year - year + 1;
		return age;
	}
	/*
	 * public int getTti(int year) { //�� }
	 */
}
